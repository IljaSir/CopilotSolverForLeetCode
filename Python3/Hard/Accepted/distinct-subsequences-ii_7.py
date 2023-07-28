class Solution:
    def distinctSubseqII(self, s: str) -> int:
        
        dp = [0] * 27
        for c in s:
            dp[ord(c) - ord('a')] = sum(dp) + 1
        return sum(dp) % (10**9 + 7)