class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        if p == ".*":
            return True
        if not s:
            return not p
        if not p:
            return not s
        if p[0] == ".":
            return self.isMatch(s[1:], p[1:])
        if len(p) > 1 and p[1] == "*":
            return self.isMatch(s, p[2:]) or (s[0] == p[0] and self.isMatch(s[1:], p))
        return s[0] == p[0] and self.isMatch(s[1:], p[1:])