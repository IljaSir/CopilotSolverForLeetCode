class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        def helper(s, i):
            if i == len(s):
                return [s]
            if s[i].isalpha():
                return helper(s[:i] + s[i].lower() + s[i+1:], i+1) + helper(s[:i] + s[i].upper() + s[i+1:], i+1)
            else:
                return helper(s, i+1)
        return helper(s, 0)