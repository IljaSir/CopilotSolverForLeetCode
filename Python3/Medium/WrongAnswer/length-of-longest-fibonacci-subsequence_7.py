class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        n = len(arr)
        dp = [[2] * n for _ in range(n)]
        res = 0
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                k = bisect.bisect_left(arr, arr[j] - arr[i], 0, i)
                if k < i and arr[k] == arr[j] - arr[i]:
                    dp[i][j] = dp[k][i] + 1
                res = max(res, dp[i][j])
        return res if res > 2 else 0