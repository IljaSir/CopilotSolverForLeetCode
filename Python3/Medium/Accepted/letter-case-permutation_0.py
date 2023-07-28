class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        res = [""]
        for c in s:
            if c.isalpha():
                res = [x + y for x in res for y in [c.lower(), c.upper()]]
            else:
                res = [x + c for x in res]
        return res