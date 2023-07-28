class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if not digits:
            return []
        d = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        def dfs(digits, path):
            if not digits:
                res.append(path)
                return
            for c in d[digits[0]]:
                dfs(digits[1:], path+c)
        res = []
        dfs(digits, "")
        return res