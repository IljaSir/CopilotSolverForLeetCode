class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(c) for c in s if c.isdigit()]
        digits = set(digits)
        if len(digits) < 2:
            return -1
        digits.remove(max(digits))
        return max(digits)