class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        self.memo = {}
        self.wordDict = set(wordDict)
        return self.dfs(s)