class Solution:
    def myAtoi(self, s: str) -> int:
        
        s = s.lstrip()
        if not s:
            return 0
        sign = 1
        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        if not s or not s[0].isdigit():
            return 0
        i = 0
        while i < len(s) and s[i].isdigit():
            i += 1
        s = s[:i]
        if int(s) < -2**31:
            return -2**31
        if int(s) > 2**31-1:
            return 2**31-1
        return int(s)*sign