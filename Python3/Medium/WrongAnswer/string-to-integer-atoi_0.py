class Solution:
    def myAtoi(self, s: str) -> int:
        
        s = s.strip()
        if not s:
            return 0
        sign = 1
        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        if not s:
            return 0
        if not s[0].isdigit():
            return 0
        for i, c in enumerate(s):
            if not c.isdigit():
                return sign * int(s[:i])
        return sign * int(s)