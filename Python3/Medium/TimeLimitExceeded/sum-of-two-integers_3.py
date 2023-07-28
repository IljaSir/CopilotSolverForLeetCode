class Solution:
    def getSum(self, a: int, b: int) -> int:
        
        if b == 0:
            return a
        return self.getSum(a ^ b, (a & b) << 1)