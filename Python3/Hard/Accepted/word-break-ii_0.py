class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        def dfs(s, wordDict, memo):
            if s in memo:
                return memo[s]
            if not s:
                return []
            res = []
            for word in wordDict:
                if s.startswith(word):
                    if len(s) == len(word):
                        res.append(word)
                    else:
                        resOfRest = dfs(s[len(word):], wordDict, memo)
                        for item in resOfRest:
                            item = word + ' ' + item
                            res.append(item)
            memo[s] = res
            return res
        memo = {}
        return dfs(s, wordDict, memo)