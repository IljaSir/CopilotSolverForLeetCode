class Solution:
    def distinctSubseqII(self, s: str) -> int:
        
        MOD = 10**9 + 7
        dp = [0] * 26
        for c in s:
            i = ord(c) - ord('a')
            dp[i] = sum(dp) % MOD + 1
        return sum(dp) % MOD