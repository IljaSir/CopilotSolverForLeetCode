class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        dp = [[0]*n for _ in range(n)]
        ans = ""
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                dp[i][j] = (s[i] == s[j] and (j-i < 2 or dp[i+1][j-1]))
                if dp[i][j] and j-i+1 > len(ans):
                    ans = s[i:j+1]
        return ans