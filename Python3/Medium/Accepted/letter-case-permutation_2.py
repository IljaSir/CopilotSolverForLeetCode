class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        if not s:
            return [""]
        if s[0].isalpha():
            return [s[0].lower() + x for x in self.letterCasePermutation(s[1:])] + [s[0].upper() + x for x in self.letterCasePermutation(s[1:])]
        else:
            return [s[0] + x for x in self.letterCasePermutation(s[1:])]