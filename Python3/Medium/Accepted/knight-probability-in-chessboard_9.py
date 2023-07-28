class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        if k == 0:
            return 1.0
        if n <= 1:
            return 0.0
        move = [[-2,-1], [-2,1], [-1,2], [1,2], [2,1], [2,-1], [1,-2], [-1,-2]]
        dp = [[0.0 for _ in range(n)] for _ in range(n)]
        dp[row][column] = 1.0
        for _ in range(k):
            tmp = [[0.0 for _ in range(n)] for _ in range(n)]
            for i in range(n):
                for j in range(n):
                    for m in move:
                        x = i + m[0]
                        y = j + m[1]
                        if x >= 0 and x < n and y >= 0 and y < n:
                            tmp[x][y] += dp[i][j] / 8
            dp = tmp
        return sum([sum(i) for i in dp])