class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = []
        for c in s:
            if c.isdigit():
                digits.append(int(c))
        digits = sorted(list(set(digits)))
        if len(digits) > 1:
            return digits[-2]
        else:
            return -1