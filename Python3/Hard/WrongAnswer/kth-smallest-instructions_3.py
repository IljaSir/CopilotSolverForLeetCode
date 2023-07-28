class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        r, c = destination
        dp = [[0] * (c + 1) for _ in range(r + 1)]
        for i in range(r + 1):
            dp[i][0] = 1
        for j in range(c + 1):
            dp[0][j] = 1
        for i in range(1, r + 1):
            for j in range(1, c + 1):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        res = []
        while r or c:
            if r and k <= dp[r - 1][c]:
                res.append('H')
                r -= 1
            else:
                res.append('V')
                k -= dp[r][c - 1]
                c -= 1
        return ''.join(res)