class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        s = set(arr)
        ans = 0
        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                if arr[j] - arr[i] < arr[i] and arr[j] - arr[i] in s:
                    dp[i][j] = dp[j][s.index(arr[j] - arr[i])] + 1
                ans = max(ans, dp[i][j])
        return ans if ans > 1 else 0