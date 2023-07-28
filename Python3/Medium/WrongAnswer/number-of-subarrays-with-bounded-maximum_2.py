class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        
        n = len(nums)
        dp = [0] * n
        dp[0] = 1 if left <= nums[0] <= right else 0
        for i in range(1, n):
            if left <= nums[i] <= right:
                dp[i] = dp[i-1] + 1
            elif nums[i] < left:
                dp[i] = dp[i-1]
        return sum(dp)