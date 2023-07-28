class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        words = set(wordDict)
        @lru_cache(None)
        def dfs(s):
            if not s:
                return [[]]
            ans = []
            for i in range(1, len(s)+1):
                if s[:i] in words:
                    for rest in dfs(s[i:]):
                        ans.append([s[:i]] + rest)
            return ans
        return [' '.join(words) for words in dfs(s)]