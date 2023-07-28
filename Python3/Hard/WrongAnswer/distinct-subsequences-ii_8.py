class Solution:
    def distinctSubseqII(self, s: str) -> int:
        
        mod = 10**9 + 7
        dp = [1] * 26
        for c in s:
            dp[ord(c) - ord('a')] = sum(dp) + 1
        return sum(dp) % mod