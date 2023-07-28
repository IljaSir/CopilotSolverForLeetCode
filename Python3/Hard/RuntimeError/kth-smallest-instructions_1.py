class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        row, col = destination
        dp = [[1] * (col + 1) for _ in range(row + 1)]
        for i in range(1, row + 1):
            for j in range(1, col + 1):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        path = ""
        while row > 0 or col > 0:
            if row > 0 and k > dp[row - 1][col]:
                path += "V"
                k -= dp[row - 1][col]
                row -= 1
            else:
                path += "H"
                col -= 1
        return path