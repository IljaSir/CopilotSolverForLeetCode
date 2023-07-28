class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        dp = [1] * len(nums)
        cnt = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]
                    elif dp[i] == dp[j] + 1:
                        cnt[i] += cnt[j]
        max_len = max(dp)
        res = 0
        for i in range(len(nums)):
            if dp[i] == max_len:
                res += cnt[i]
        return res