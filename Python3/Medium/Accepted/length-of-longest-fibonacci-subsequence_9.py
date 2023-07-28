class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        n = len(arr)
        dp = [[2 for j in range(n)] for i in range(n)]
        mp = {arr[i]:i for i in range(n)}
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if arr[j]-arr[i] in mp and mp[arr[j]-arr[i]] < i:
                    dp[i][j] = dp[mp[arr[j]-arr[i]]][i] + 1
                ans = max(ans, dp[i][j])
        return ans if ans > 2 else 0