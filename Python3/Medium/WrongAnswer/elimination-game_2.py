class Solution:
    def lastRemaining(self, n: int) -> int:
        
        if n == 1:
            return 1
        if n % 2 == 0:
            return 2 * self.lastRemaining(n // 2)
        else:
            return 2 * self.lastRemaining(n // 2) - 1