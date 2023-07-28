class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if not digits:
            return []
        letter = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        res = [""]
        for num in digits:
            tmp = []
            for prefix in res:
                for char in letter[num]:
                    tmp.append(prefix + char)
            res = tmp
        return res