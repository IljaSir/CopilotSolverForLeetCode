class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        
        banned = set(banned)
        dp = [0] * (maxSum + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            if i in banned:
                continue
            for j in range(maxSum, i - 1, -1):
                dp[j] += dp[j - i]
        return dp[maxSum]