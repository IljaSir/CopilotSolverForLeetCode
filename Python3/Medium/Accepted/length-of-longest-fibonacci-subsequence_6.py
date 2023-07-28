class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        s = set(arr)
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        res = 0
        for i in range(n):
            for j in range(i + 1, n):
                if arr[j] - arr[i] < arr[i] and arr[j] - arr[i] in s:
                    dp[i][j] = dp[arr.index(arr[j] - arr[i])][i] + 1
                    res = max(res, dp[i][j])
        return res + 2 if res else 0