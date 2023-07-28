class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        
        n = len(s)
        if n == 0:
            return 0
        # dp[i] = longest ideal string ending at s[i]
        dp = [1] * n
        for i in range(1, n):
            if ord(s[i]) - ord(s[i-1]) <= k:
                dp[i] = dp[i-1] + 1
        return max(dp)