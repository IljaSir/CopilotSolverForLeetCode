class Solution:
    def reformat(self, s: str) -> str:
        
        # Split the string into two lists of letters and digits
        letters = [c for c in s if c.isalpha()]
        digits = [c for c in s if c.isdigit()]
        # If the difference in lengths is greater than 1, return ""
        if abs(len(letters) - len(digits)) > 1:
            return ""
        # If there are more letters, put them first
        if len(letters) > len(digits):
            return "".join([a + b for a, b in zip(letters, digits)])
        # Otherwise, put the digits first
        return "".join([a + b for a, b in zip(digits, letters)])