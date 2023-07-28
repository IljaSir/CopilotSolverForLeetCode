class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        def match(s, p):
            if not p:
                return not s
            if not s:
                return all(c == '*' for c in p)
            if p[0] == '*':
                return match(s, p[1:]) or match(s[1:], p)
            if p[0] == '?' or s[0] == p[0]:
                return match(s[1:], p[1:])
            return False
        return match(s, p)