class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        
        nums.sort()
        n = len(nums)
        dp = [1] * n
        for i in range(n):
            for j in range(i):
                if (nums[i] - nums[j]) % space == 0:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)