class Solution:
    def makeIntegerBeautiful(self, n: int, target: int) -> int:
        
        # 1 <= n <= 10^12
        # 1 <= target <= 150
        # The input will be generated such that it is always possible to make n beautiful.
        # So we don't need to check if n is beautiful
        # We just need to check if n + x is beautiful
        # We can use a greedy approach