class Solution:
    def numberOfUniqueGoodSubsequences(self, binary: str) -> int:
        
        MOD = 10**9 + 7
        n = len(binary)
        dp = [0] * n
        dp[0] = 2 if binary[0] == '1' else 1
        for i in range(1, n):
            if binary[i] == '0':
                dp[i] = dp[i-1]
            else:
                dp[i] = (dp[i-1] * 2) % MOD
        for i in range(1, n):
            if binary[i] == '1':
                dp[i] = (dp[i] + dp[i-1]) % MOD
        return dp[-1] - 1 if binary[-1] == '0' else dp[-1]