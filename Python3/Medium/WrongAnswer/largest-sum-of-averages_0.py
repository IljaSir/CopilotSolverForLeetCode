class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        N = len(nums)
        dp = [0] * N
        dp[0] = nums[0]
        for i in range(1, N):
            dp[i] = dp[i-1] + nums[i]
        for i in range(1, k):
            for j in range(N-1, i-1, -1):
                for m in range(i-1, j):
                    dp[j] = max(dp[j], (dp[j]-dp[m])/(j-m) + dp[m]/(m-i+2))
        return dp[N-1]/k