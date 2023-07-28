class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n < 2:
            return n
        dp = [[1, 1] for _ in range(n)]
        for i in range(1, n):
            if arr[i] > arr[i - 1]:
                dp[i][0] = dp[i - 1][1] + 1
            elif arr[i] < arr[i - 1]:
                dp[i][1] = dp[i - 1][0] + 1
        return max(max(dp))