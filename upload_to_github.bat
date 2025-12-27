@echo off
cd /d "%~dp0"

echo ========================================
echo Git Auto-Sync Script (Robust Mode)
echo ========================================

echo 1. Clearing any stuck Git locks/processes...
taskkill /F /IM git.exe 2>nul
taskkill /F /IM "git-remote-https.exe" 2>nul

if exist ".git\index.lock" (
    echo    - Removing index.lock
    del ".git\index.lock" /F /Q
)
if exist ".git\rebase-merge" (
    echo    - Removing rebase-merge directory
    rd ".git\rebase-merge" /S /Q
)
if exist ".git\rebase-apply" (
    echo    - Removing rebase-apply directory
    rd ".git\rebase-apply" /S /Q
)

echo.
echo 2. Initializing/Checking Repository...
if not exist .git git init

echo 3. Checking Remote...
git remote add origin https://github.com/codefoxsoft/Java 2>nul

echo.
echo 4. Aborting any previous failed operations...
git rebase --abort 2>nul
git merge --abort 2>nul

echo.
echo 5. Syncing changes...
echo    - Adding files...
git add .
echo    - Committing...
git commit -m "Update sorted Java projects"

echo.
echo 6. Pulling and Rebasing from remote...
git pull origin main --allow-unrelated-histories --rebase
if %errorlevel% neq 0 (
    echo.
    echo [!] Conflict or Error during pull. 
    echo     Please resolve conflicts manually or check the output above.
    pause
    exit /b %errorlevel%
)

echo.
echo 7. Pushing to GitHub...
git push -u origin main

echo.
echo ========================================
echo Sync Complete!
echo ========================================
pause
