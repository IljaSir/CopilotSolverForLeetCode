class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # DP
        # dp[i] = min(dp[i], dp[j]+1) for j in range(i)
        # dp[i] = min(dp[i], dp[j]+1) for j in range(i-nums[i], i)
        # dp[i] = min(dp[i], dp[j]+1) for j in range(i-nums[i], i+1)
        # dp[i] = min(dp[i], dp[j]+1) for j in range(max(0, i-nums[i]), i+1)
        
        # dp[i] = min(dp[i], dp[j]+1) for j in range(max(0, i-nums[i]), i+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+1, dp[i-2]+1, ..., dp[i-nums[i]]+1)
        # dp[i] = min(dp[i], dp[i-1]+