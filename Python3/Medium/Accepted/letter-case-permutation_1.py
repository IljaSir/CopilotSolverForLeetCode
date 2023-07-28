class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        res = [""]
        for ch in s:
            if ch.isalpha():
                res = [i + j for i in res for j in [ch.lower(), ch.upper()]]
            else:
                res = [i + ch for i in res]
        return res