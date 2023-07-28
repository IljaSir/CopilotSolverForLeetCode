class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        n = len(s)
        dp = [False for _ in range(n+1)]
        dp[0] = True
        for i in range(n):
            for j in range(i+1, n+1):
                if dp[i] and s[i:j] in wordDict:
                    dp[j] = True
        if not dp[-1]:
            return []
        res = []
        self.dfs(s, wordDict, [], res)
        return res