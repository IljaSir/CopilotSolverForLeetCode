class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        def permute(s, i):
            if i == len(s):
                return [s]
            res = []
            if s[i].isalpha():
                res += permute(s[:i] + s[i].lower() + s[i+1:], i+1)
                res += permute(s[:i] + s[i].upper() + s[i+1:], i+1)
            else:
                res += permute(s, i+1)
            return res
        return permute(s, 0)