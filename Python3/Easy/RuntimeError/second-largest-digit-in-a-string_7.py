class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(c) for c in s if c.isdigit()]
        if len(digits) < 2:
            return -1
        digits = sorted(set(digits))
        return digits[-2]