class Solution:
    def integerReplacement(self, n: int) -> int:
        
        if n == 1:
            return 0
        elif n == 2:
            return 1
        elif n == 3:
            return 2
        elif n % 2 == 0:
            return 1 + self.integerReplacement(n // 2)
        else:
            return 1 + min(self.integerReplacement(n + 1), self.integerReplacement(n - 1))