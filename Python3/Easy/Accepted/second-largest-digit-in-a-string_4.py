class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = []
        for c in s:
            if c.isdigit():
                digits.append(int(c))
        digits = set(digits)
        if len(digits) < 2:
            return -1
        else:
            digits.remove(max(digits))
            return max(digits)