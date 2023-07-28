class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        cnt = Counter(nums)
        dp = [0] * 10001
        dp[1] = cnt[1]
        for i in range(2, 10001):
            dp[i] = max(dp[i-1], dp[i-2] + cnt[i] * i)
        return dp[-1]