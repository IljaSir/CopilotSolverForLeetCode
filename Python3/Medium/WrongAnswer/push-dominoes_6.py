class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        
        if not dominoes:
            return dominoes
        n = len(dominoes)
        dp = [0] * n
        for i in range(n):
            if dominoes[i] == 'L':
                dp[i] = -1
            elif dominoes[i] == 'R':
                dp[i] = 1
        # print(dp)
        for i in range(n):
            if dp[i] == 1:
                for j in range(i+1, n):
                    if dp[j] == 0:
                        dp[j] = 1
                    else:
                        break
        # print(dp)
        for i in range(n-1, -1, -1):
            if dp[i] == -1:
                for j in range(i-1, -1, -1):
                    if dp[j] == 0:
                        dp[j] = -1
                    else:
                        break
        # print(dp)
        for i in range(n):
            if dp[i] == 1:
                dominoes = dominoes[:i] + 'R' + dominoes[i+1:]
            elif dp[i] == -1:
                dominoes = dominoes[:i] + 'L' + dominoes[i+1:]
        return dominoes