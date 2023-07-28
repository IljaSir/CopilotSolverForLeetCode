class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        row, col = destination
        n = row + col
        dp = [[1] * (n + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        ans = []
        i, j = 0, 0
        while i < row or j < col:
            if i < row and j < col:
                if dp[i + 1][j] >= k:
                    ans.append('H')
                    j += 1
                else:
                    ans.append('V')
                    k -= dp[i + 1][j]
                    i += 1
            elif i < row:
                ans.append('V')
                i += 1
            else:
                ans.append('H')
                j += 1
        return ''.join(ans)