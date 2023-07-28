class Solution:
    def baseNeg2(self, n: int) -> str:
        
        if n == 0:
            return '0'
        res = ''
        while n:
            n, r = divmod(n, -2)
            res = str(r) + res
            if r < 0:
                n += 1
        return res