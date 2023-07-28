class Solution:
    def numSquares(self, n: int) -> int:
        
        if n == 1:
            return 1
        squares = []
        i = 1
        while i*i <= n:
            squares.append(i*i)
            i += 1
        # print(squares)
        dp = [float('inf') for i in range(n+1)]
        dp[0] = 0
        for i in range(1, n+1):
            for j in range(len(squares)):
                if i - squares[j] >= 0:
                    dp[i] = min(dp[i], dp[i-squares[j]]+1)
        return dp[-1]