class Solution:
    def minOperations(self, n: int) -> int:
        
        return sum([abs(i - (2 * (n - i) - 1)) for i in range(1, n + 1, 2)]) // 2