class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(c) for c in s if c.isdigit()]
        if len(digits) <= 1:
            return -1
        digits = list(set(digits))
        digits.sort(reverse=True)
        return digits[1]