class Solution:
    def numPermsDISequence(self, s: str) -> int:
        
        N = len(s)
        dp = [1] * (N+1)
        for x in s:
            if x == 'I':
                for i in range(1, N+1):
                    dp[i] += dp[i-1]
            else:
                for i in range(N-1, -1, -1):
                    dp[i] = dp[i] + dp[i+1]
        return dp[0] % (10**9 + 7)