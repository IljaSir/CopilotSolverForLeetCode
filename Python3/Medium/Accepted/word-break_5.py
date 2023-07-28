class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        dp = [False] * len(s)
        for i in range(len(s)):
            for j in range(i + 1):
                if s[j:i + 1] in wordDict and (dp[j - 1] or j == 0):
                    dp[i] = True
        return dp[-1]