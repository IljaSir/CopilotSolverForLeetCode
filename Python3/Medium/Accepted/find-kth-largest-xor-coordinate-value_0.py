class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        res = []
        for i in range(m):
            for j in range(n):
                dp[i + 1][j + 1] = dp[i][j] ^ dp[i][j + 1] ^ dp[i + 1][j] ^ matrix[i][j]
                res.append(dp[i + 1][j + 1])
        res.sort(reverse=True)
        return res[k - 1]