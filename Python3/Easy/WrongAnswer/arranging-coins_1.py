class Solution:
    def arrangeCoins(self, n: int) -> int:
        
        if n < 2:
            return n
        i = 1
        while n > i:
            n -= i
            i += 1
        return i