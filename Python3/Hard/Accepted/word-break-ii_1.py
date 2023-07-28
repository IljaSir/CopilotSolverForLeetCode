class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        
        def helper(s, wordDict, memo):
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
                        res += [word + ' ' + rest for rest in helper(s[len(word):], wordDict, memo)]
            memo[s] = res
            return res
        return helper(s, wordDict, {})