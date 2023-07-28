class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n <= 1:
            return n
        dp = [1] * n
        count = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[i] == dp[j] + 1:
                        count[i] += count[j]
                    elif dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        count[i] = count[j]
        longest = max(dp)
        return sum(c for i, c in enumerate(count) if dp[i] == longest)