class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        dp = [0, 0]
        for num in nums:
            dp = [max(dp[0], dp[1] + num), max(dp[1], dp[0] - num)]
        return max(dp)