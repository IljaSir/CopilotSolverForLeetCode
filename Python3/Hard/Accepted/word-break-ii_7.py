class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        wordDict = set(wordDict)
        @functools.lru_cache(maxsize=None)
        def dfs(s):
            if not s:
                return [[]]
            res = []
            for i in range(1, len(s) + 1):
                if s[:i] in wordDict:
                    for j in dfs(s[i:]):
                        res.append([s[:i]] + j)
            return res
        return [" ".join(x) for x in dfs(s)]