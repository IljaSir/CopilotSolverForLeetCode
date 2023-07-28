class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        
        
        # dp[i][j]: the min capability to rob j houses from 0 to i
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i], nums[i-1], nums[i-2]), ..., dp[k-1][j-k+1] + max(nums[i], nums[i-1], ..., nums[i-k+1]))
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i], nums[i-1], nums[i-2]), ..., dp[k-1][j-k+1] + max(nums[i], nums[i-1], ..., nums[i-k+1]))
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i], nums[i-1], nums[i-2]), ..., dp[i-k][j-k+1] + max(nums[i], nums[i-1], ..., nums[i-k+1]))
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i], nums[i-1], nums[i-2]), ..., dp[i-(j-1)][1] + max(nums[i], nums[i-1], ..., nums[i-(j-1)]))
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i], nums[i-1], nums[i-2]), ..., dp[i-(j-1)][1] + max(nums[i], nums[i-(j-1)]))
        # dp[i][j] = min(dp[i-1][j], dp[i-2][j-1] + max(nums[i], nums[i-1]), dp[i-3][j-2] + max(nums[i