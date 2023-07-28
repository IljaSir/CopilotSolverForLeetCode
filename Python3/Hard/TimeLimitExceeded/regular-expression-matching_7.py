class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        # print(s, p)
        if len(p) == 0:
            return len(s) == 0
        is_first_match = len(s) > 0 and (s[0] == p[0] or p[0] == '.')
        if len(p) > 1 and p[1] == '*':
            return self.isMatch(s, p[2:]) or (is_first_match and self.isMatch(s[1:], p))
        else:
            return is_first_match and self.isMatch(s[1:], p[1:])