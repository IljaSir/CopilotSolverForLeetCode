class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        if k == n:
            return max(nums)
        if k == 1:
            return min(nums)
        dp = [0] * n
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, n):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        #print(dp)
        res = float('inf')
        for i in range(k - 1, n):
            res = min(res, max(dp[i], dp[i - k]))
        return res