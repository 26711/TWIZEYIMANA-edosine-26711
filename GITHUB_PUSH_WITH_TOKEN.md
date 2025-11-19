# 🚀 Push to GitHub Using Token (Without Changing Git Config)

## Step 1: Create GitHub Personal Access Token

1. **Go to GitHub**: https://github.com/settings/tokens
2. **Click**: "Generate new token" → "Generate new token (classic)"
3. **Name it**: "Edo Assignment" or "26711 Assignment"
4. **Select scopes**: Check ✅ **"repo"** (this gives full repository access)
5. **Click**: "Generate token"
6. **⚠️ IMPORTANT**: **Copy the token immediately** - you won't see it again!
   - It looks like: `ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx`

---

## Step 2: Create GitHub Repository

1. **Go to**: https://github.com/new
2. **Repository name**: `Edo` (or your project name)
3. **Description**: "Assignment submission"
4. **Visibility**: Choose Public or Private (as required)
5. **⚠️ DO NOT** check "Initialize with README"
6. **Click**: "Create repository"
7. **Copy the repository URL** (you'll need it)
   - Example: `https://github.com/26711/Edo.git`
   - **Note**: Your GitHub username MUST be your student ID (26711)

---

## Step 3: Add Files and Commit (If Not Done)

```powershell
# Make sure you're in the project folder
cd C:\Users\Pacifique\Documents\project\Edo

# Check status
git status

# Add all files
git add .

# Commit (if not already committed)
git commit -m "Initial commit - Assignment submission"
```

---

## Step 4: Add Remote Repository

```powershell
# Add your GitHub repository as remote
# Replace 26711 with your actual GitHub username (must be your student ID)
git remote add origin https://github.com/26711/Edo.git

# Verify it was added
git remote -v
```

---

## Step 5: Push Using Token

### Option A: Push with Token in URL (Recommended)

```powershell
# When Git asks for username: enter your GitHub username (26711)
# When Git asks for password: paste your TOKEN (not your password!)

git push -u origin main
```

**OR** if you get an error about branch name:

```powershell
git push -u origin master
```

### Option B: Push with Token Embedded in URL (One-time)

```powershell
# Replace YOUR_TOKEN with the token you copied
# Replace 26711 with your GitHub username

git push https://YOUR_TOKEN@github.com/26711/Edo.git main
```

**Example:**
```powershell
git push https://ghp_abc123xyz@github.com/26711/Edo.git main
```

### Option C: Use Git Credential Manager (Windows)

```powershell
# Push normally
git push -u origin main

# When prompted:
# Username: 26711 (your GitHub username)
# Password: ghp_your_token_here (paste your token)
```

---

## Step 6: Verify Push

1. **Go to**: https://github.com/26711/Edo
2. **Check**: You should see all your files:
   - `_26711/` folder
   - `q1/`, `q2/`, `q3/`, `q4/`, `q5/`, `q6/` folders
   - All Java files
   - `.gitignore`
   - Documentation files

---

## 🔐 Security Notes

- ✅ **Token is safer** than password
- ✅ **Token can be revoked** if needed
- ⚠️ **Never share your token** publicly
- ⚠️ **Don't commit token** to Git

---

## 🆘 Troubleshooting

### Error: "remote origin already exists"
```powershell
# Remove existing remote
git remote remove origin

# Add again
git remote add origin https://github.com/26711/Edo.git
```

### Error: "Authentication failed"
- Make sure you're using the **token**, not your password
- Check that token has "repo" scope enabled
- Token might have expired - generate a new one

### Error: "branch 'main' does not exist"
```powershell
# Check your branch name
git branch

# If it's 'master', use:
git push -u origin master
```

### Error: "repository not found"
- Check your GitHub username is correct (must be 26711)
- Make sure repository exists on GitHub
- Verify repository name matches

---

## 📋 Quick Checklist

- [ ] Created GitHub account with username = student ID (26711)
- [ ] Generated Personal Access Token with "repo" scope
- [ ] Created GitHub repository named "Edo"
- [ ] Copied repository URL
- [ ] Initialized Git (if not done): `git init`
- [ ] Added files: `git add .`
- [ ] Committed: `git commit -m "Initial commit"`
- [ ] Added remote: `git remote add origin https://github.com/26711/Edo.git`
- [ ] Pushed: `git push -u origin main` (use token as password)

---

## ✅ Success!

Once pushed, your repository URL will be:
**https://github.com/26711/Edo**

Use this URL in the Google Form submission!

