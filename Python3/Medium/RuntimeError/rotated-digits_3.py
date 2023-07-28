class Solution:
    def rotatedDigits(self, n: int) -> int:
        
        count = 0
        for i in range(1, n+1):
            if self.isGood(i):
                count += 1
        return count