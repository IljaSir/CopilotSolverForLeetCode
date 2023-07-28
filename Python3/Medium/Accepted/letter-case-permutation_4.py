class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        def dfs(s, i, res):
            if i == len(s):
                res.append(s)
                return
            dfs(s, i+1, res)
            if s[i].isalpha():
                dfs(s[:i]+s[i].swapcase()+s[i+1:], i+1, res)
        res = []
        dfs(s, 0, res)
        return res