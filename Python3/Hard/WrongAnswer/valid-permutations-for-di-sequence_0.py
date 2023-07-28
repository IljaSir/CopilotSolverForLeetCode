class Solution:
    def numPermsDISequence(self, s: str) -> int:
        
        n = len(s)
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = 1
        for i in range(1, n + 1):
            if s[i - 1] == 'I':
                for j in range(i):
                    dp[i][j] = sum(dp[i - 1][:j + 1])
            else:
                for j in range(i):
                    dp[i][j] = sum(dp[i - 1][j:])
        return sum(dp[n]) % (10 ** 9 + 7)