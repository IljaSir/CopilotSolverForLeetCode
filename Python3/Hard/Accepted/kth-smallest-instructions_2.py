class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        row, col = destination
        dp = [[0]*(col+1) for _ in range(row+1)]
        dp[0][0] = 1
        for i in range(row+1):
            for j in range(col+1):
                if i == 0 and j == 0:
                    continue
                if i == 0:
                    dp[i][j] = dp[i][j-1]
                elif j == 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
        path = ''
        while row > 0 or col > 0:
            if row == 0:
                path += 'H'
                col -= 1
            elif col == 0:
                path += 'V'
                row -= 1
            else:
                if dp[row][col-1] >= k:
                    path += 'H'
                    col -= 1
                else:
                    path += 'V'
                    k -= dp[row][col-1]
                    row -= 1
        return path