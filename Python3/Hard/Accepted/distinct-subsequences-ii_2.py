class Solution:
    def distinctSubseqII(self, s: str) -> int:
        
        MOD = 10**9 + 7
        dp = [0] * 26
        for c in s:
            dp[ord(c) - ord('a')] = sum(dp) + 1
        return sum(dp) % MOD