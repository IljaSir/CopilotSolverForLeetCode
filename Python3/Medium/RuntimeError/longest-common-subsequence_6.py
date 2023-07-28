class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        # dp
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if text1[i] != text2[j]
        # dp[i][j] = dp[i-1][j-1] + 1 if text1[i] == text2[j]
        # dp[i][j] = max(dp[i-1][j], dp[i][j-1]) if