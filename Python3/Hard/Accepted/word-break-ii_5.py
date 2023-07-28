class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        memo = {}
        def backtrack(s):
            if s in memo:
                return memo[s]
            if not s:
                return []
            res = []
            for w in wordDict:
                if s.startswith(w):
                    if len(s) == len(w):
                        res.append(w)
                    else:
                        res.extend([w + ' ' + r for r in backtrack(s[len(w):])])
            memo[s] = res
            return res
        return backtrack(s)