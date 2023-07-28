class Solution:
    def countVowelStrings(self, n: int) -> int:
        
        # Solution 1: Dynamic Programming
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # dp = [1, 1, 1, 1, 1]
        # for _ in range(n - 1):
        #     for i in range(1, 5):
        #         dp[i] += dp[i - 1]
        # return sum(dp)
        # Solution 2: Dynamic Programming
        # Time  complexity: O(n)
        # Space complexity: O(1)
        dp = [1] * 5
        for _ in range(n - 1):
            for i in range(4, -1, -1):
                dp[i] += dp[i + 1]
        return sum(dp)