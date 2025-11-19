# ⚡ Quick Steps to Push with Token

## 🎯 Fast Method (Using Token)

### 1. Get Your Token
- Go to: https://github.com/settings/tokens
- Generate new token (classic)
- Check "repo" scope
- Copy the token (starts with `ghp_`)

### 2. Create Repository on GitHub
- Go to: https://github.com/new
- Name: `Edo`
- **Username must be**: `26711` (your student ID)
- Don't initialize with README
- Create repository

### 3. Push Your Code

```powershell
# Add all files
git add .

# Commit
git commit -m "Assignment submission - Student ID 26711"

# Add remote (replace 26711 if different)
git remote add origin https://github.com/26711/Edo.git

# Push (use token as password when asked)
git push -u origin main
```

**When prompted:**
- **Username**: `26711`
- **Password**: `paste_your_token_here` (the `ghp_...` token, NOT your GitHub password)

---

## 🔄 Alternative: One-Line Push with Token

```powershell
git push https://YOUR_TOKEN@github.com/26711/Edo.git main
```

Replace `YOUR_TOKEN` with your actual token.

---

## ✅ Done!

Your code will be at: **https://github.com/26711/Edo**

