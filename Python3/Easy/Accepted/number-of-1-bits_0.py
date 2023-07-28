class Solution:
    def hammingWeight(self, n: int) -> int:
        
        w = 0
        while n:
            w += 1
            n &= n - 1
        return w