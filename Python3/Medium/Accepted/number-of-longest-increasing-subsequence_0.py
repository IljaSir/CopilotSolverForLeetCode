class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        n = len(nums)
        dp = [1] * n
        cnt = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[j] + 1 > dp[i]:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]
                    elif dp[j] + 1 == dp[i]:
                        cnt[i] += cnt[j]
        longest = max(dp)
        return sum(c for i, c in enumerate(cnt) if dp[i] == longest)