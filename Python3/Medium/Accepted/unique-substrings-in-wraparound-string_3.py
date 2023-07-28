class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        
        n = len(s)
        if n == 1:
            return 1
        dp = [0] * 26
        dp[ord(s[0]) - ord('a')] = 1
        max_len = 1
        for i in range(1, n):
            if (ord(s[i]) - ord(s[i - 1])) % 26 == 1:
                max_len += 1
            else:
                max_len = 1
            dp[ord(s[i]) - ord('a')] = max(dp[ord(s[i]) - ord('a')], max_len)
        return sum(dp)