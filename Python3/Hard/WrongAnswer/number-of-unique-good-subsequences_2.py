class Solution:
    def numberOfUniqueGoodSubsequences(self, binary: str) -> int:
        
        MOD = 10**9 + 7
        dp = [1, 1]
        for c in binary:
            if c == '1':
                dp[1] = (dp[0] + dp[1]) % MOD
            else:
                dp[0] = (dp[0] + dp[1]) % MOD
        return (dp[0] + dp[1] - 1) % MOD