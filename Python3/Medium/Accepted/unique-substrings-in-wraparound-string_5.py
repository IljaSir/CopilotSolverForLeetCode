class Solution:
    def findSubstringInWraproundString(self, s: str) -> int:
        
        if not s: return 0
        # dp[i] means the number of substring ends with i
        dp = [0]*26
        # count the continuous substring
        count = 0
        for i in range(len(s)):
            if i > 0 and (ord(s[i]) - ord(s[i-1])) % 26 == 1:
                count += 1
            else:
                count = 1
            # update dp
            dp[ord(s[i]) - ord('a')] = max(dp[ord(s[i]) - ord('a')], count)
        return sum(dp)