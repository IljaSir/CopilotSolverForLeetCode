class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        row = destination[0]
        col = destination[1]
        dp = [[0 for _ in range(col+1)] for _ in range(row+1)]
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
        res = ""
        while row > 0 and col > 0:
            if dp[row-1][col] >= k:
                res += "H"
                row -= 1
            else:
                res += "V"
                k -= dp[row-1][col]
                col -= 1
        while row > 0:
            res += "H"
            row -= 1
        while col > 0:
            res += "V"
            col -= 1
        return res