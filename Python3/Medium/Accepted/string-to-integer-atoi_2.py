class Solution:
    def myAtoi(self, s: str) -> int:
        
        s = s.strip()
        if len(s) == 0:
            return 0
        sign = 1
        if s[0] == '-':
            sign = -1
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        res = 0
        for c in s:
            if not c.isdigit():
                break
            res = res * 10 + int(c)
        return max(-2 ** 31, min(sign * res, 2 ** 31 - 1))