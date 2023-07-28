class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        n = len(arr)
        dp = [[2]*n for _ in range(n)]
        res = 0
        for i in range(2, n):
            l, r = 0, i-1
            while l < r:
                if arr[l] + arr[r] == arr[i]:
                    dp[r][i] = dp[l][r] + 1
                    res = max(res, dp[r][i])
                    l += 1
                    r -= 1
                elif arr[l] + arr[r] < arr[i]:
                    l += 1
                else:
                    r -= 1
        return res