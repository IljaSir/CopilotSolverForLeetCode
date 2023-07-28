class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        
        return all([n & 1 == (n >> 1) & 1 for n in range(n)])