class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if not digits:
            return []
        mapping = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        res = []
        def dfs(path, index):
            if len(path) == len(digits):
                res.append(path)
                return
            for i in range(index, len(digits)):
                for c in mapping[digits[i]]:
                    dfs(path + c, i + 1)
        dfs("", 0)
        return res