class Solution:
    def reformat(self, s: str) -> str:
        
        letters = [c for c in s if c.isalpha()]
        digits = [c for c in s if c.isdigit()]
        if abs(len(letters) - len(digits)) > 1:
            return ""
        if len(letters) >= len(digits):
            return "".join([a + b for a, b in zip(letters, digits)])
        else:
            return "".join([a + b for a, b in zip(digits, letters)])