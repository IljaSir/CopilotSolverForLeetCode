class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return self.get_letter(digits)
        return self.get_letter(digits[0]) + self.letterCombinations(digits[1:])