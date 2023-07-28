class Solution:
    def addBinary(self, a: str, b: str) -> str:
        
        def to_int(s):
            res = 0
            for i in range(len(s)):
                res += int(s[i]) * (1 << (len(s) - 1 - i))
            return res
        def to_str(n):
            if n == 0:
                return '0'
            res = ''
            while n > 0:
                res = str(n % 2) + res
                n //= 2
            return res
        return to_str(to_int(a) + to_int(b))