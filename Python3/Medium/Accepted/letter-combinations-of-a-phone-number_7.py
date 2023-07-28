class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if not digits:
            return []
        dmap = {
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
        def dfs(i, s):
            if i == len(digits):
                ans.append(''.join(s))
                return
            for c in dmap[digits[i]]:
                dfs(i+1, s+[c])
        dfs(0, [])
        return ans