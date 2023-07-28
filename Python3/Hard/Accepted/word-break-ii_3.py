class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        wordDict = set(wordDict)
        memo = {}
        def dfs(s):
            if s in memo:
                return memo[s]
            if not s:
                return [[]]
            res = []
            for i in range(1, len(s)+1):
                word = s[:i]
                if word in wordDict:
                    for rest in dfs(s[i:]):
                        res.append([word] + rest)
            memo[s] = res
            return res
        return [' '.join(words) for words in dfs(s)]