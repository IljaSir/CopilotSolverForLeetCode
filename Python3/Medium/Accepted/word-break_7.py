class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if not s:
            return True
        if not wordDict:
            return False
        wordSet = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        return dp[-1]