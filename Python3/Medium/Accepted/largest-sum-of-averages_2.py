class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        
        N = len(nums)
        A = [0] * (N+1)
        for i in range(N):
            A[i+1] = A[i] + nums[i]
        def average(i, j):
            return (A[j] - A[i]) / (j - i)
        dp = [average(i, N) for i in range(N)]
        for _ in range(k-1):
            for i in range(N):
                for j in range(i+1, N):
                    dp[i] = max(dp[i], average(i, j) + dp[j])
        return dp[0]