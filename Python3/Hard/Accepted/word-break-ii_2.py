class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        memo = {}
        def dfs(s):
            if s in memo: return memo[s]
            if not s: return []
            res = []
            for word in wordDict:
                if s.startswith(word):
                    if len(s) == len(word):
                        res.append(word)
                    else:
                        res += [word + ' ' + rest for rest in dfs(s[len(word):])]
            memo[s] = res
            return res
        return dfs(s)