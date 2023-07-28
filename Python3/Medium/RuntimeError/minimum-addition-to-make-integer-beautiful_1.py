class Solution:
    def makeIntegerBeautiful(self, n: int, target: int) -> int:
        
        digit_sum = sum(int(d) for d in str(n))
        if digit_sum <= target:
            return 0
        else:
            return self.makeIntegerBeautiful(n + 1, target) + 1