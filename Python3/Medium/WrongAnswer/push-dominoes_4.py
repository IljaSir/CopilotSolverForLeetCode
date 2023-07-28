class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        n = len(dominoes)
        dp = [0] * n
        for i in range(n):
            if dominoes[i] == 'R':
                dp[i] = 1
            elif dominoes[i] == 'L':
                dp[i] = -1
        for i in range(1, n):
            if dp[i] == 0:
                dp[i] = dp[i-1]
        for i in range(n-2, -1, -1):
            if dp[i] == 0:
                dp[i] = dp[i+1]
        for i in range(n):
            if dp[i] == 1:
                dp[i] = 'R'
            elif dp[i] == -1:
                dp[i] = 'L'
            else:
                dp[i] = '.'
        return ''.join(dp)