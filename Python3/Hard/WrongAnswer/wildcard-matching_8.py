class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        if not p:
            return not s
        if not s and p == '*':
            return True
        if not s:
            return False
        if p[0] == '*':
            return self.isMatch(s, p[1:]) or self.isMatch(s[1:], p)
        else:
            return (p[0] == '?' or p[0] == s[0]) and self.isMatch(s[1:], p[1:])