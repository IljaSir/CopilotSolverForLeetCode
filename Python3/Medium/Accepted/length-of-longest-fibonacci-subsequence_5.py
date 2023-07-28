class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        
        n = len(arr)
        dp = [[0] * n for _ in range(n)]
        index = {x: i for i, x in enumerate(arr)}
        longest = 0
        for k in range(n):
            for j in range(k+1, n):
                i = index.get(arr[j] - arr[k], None)
                if i is not None and i < k:
                    dp[j][k] = dp[k][i] + 1
                    longest = max(longest, dp[j][k])
        return longest + 2 if longest else 0