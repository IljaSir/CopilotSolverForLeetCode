class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        if not dominoes:
            return dominoes
        n = len(dominoes)
        #dp = [[0,0] for _ in range(n)]
        dp = [[0,0] for _ in range(n)]
        for i in range(n):
            if dominoes[i] == 'L':
                dp[i][0] = 1
                for j in range(i-1, -1, -1):
                    if dominoes[j] == 'R':
                        break
                    dp[j][0] = dp[j+1][0] + 1
            elif dominoes[i] == 'R':
                dp[i][1] = 1
                for j in range(i+1, n):
                    if dominoes[j] == 'L':
                        break
                    dp[j][1] = dp[j-1][1] + 1
        res = ''
        for i in range(n):
            if dp[i][0] == dp[i][1]:
                res += '.'
            elif dp[i][0] < dp[i][1]:
                res += 'R'
            else:
                res += 'L'
        return res