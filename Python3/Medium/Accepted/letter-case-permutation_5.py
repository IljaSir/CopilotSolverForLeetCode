class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        def dfs(i, s, res):
            if i == len(s):
                res.append(s)
                return
            dfs(i+1, s, res)
            if s[i].isalpha():
                dfs(i+1, s[:i] + s[i].swapcase() + s[i+1:], res)
        res = []
        dfs(0, s, res)
        return res