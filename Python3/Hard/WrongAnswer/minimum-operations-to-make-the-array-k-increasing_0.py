class Solution:
    def kIncreasing(self, arr: List[int], k: int) -> int:
        
        n = len(arr)
        dp = [0] * n
        for i in range(1, n):
            dp[i] = max(dp[i], dp[i-1] + arr[i] - arr[i-1])
            if i >= k:
                dp[i] = min(dp[i], dp[i-k] + arr[i] - arr[i-k])
        return dp[-1]