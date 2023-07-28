class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(c) for c in s if c.isdigit()]
        digits = list(set(digits))
        digits.sort()
        if len(digits) < 2:
            return -1
        return digits[-2]