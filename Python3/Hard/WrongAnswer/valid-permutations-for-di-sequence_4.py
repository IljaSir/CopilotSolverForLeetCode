class Solution:
    def numPermsDISequence(self, s: str) -> int:
        
        n = len(s)
        dp = [1] * (n+1)
        for ch in s:
            if ch == 'I':
                for i in range(1, n+1):
                    dp[i] += dp[i-1]
            else:
                for i in range(n-1, -1, -1):
                    dp[i] += dp[i+1]
        return dp[0] % (10**9+7)