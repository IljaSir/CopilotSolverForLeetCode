class Solution:
    def concatenatedBinary(self, n: int) -> int:
        
        res = 0
        for i in range(1, n+1):
            res = (res << (len(bin(i)) - 2)) + i
        return res % (10**9 + 7)