class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if not digits:
            return []
        m = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        ans = []
        def dfs(digits, path):
            if not digits:
                ans.append(path)
                return
            for c in m[digits[0]]:
                dfs(digits[1:], path + c)
        dfs(digits, '')
        return ans