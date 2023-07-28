class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(x) for x in s if x.isdigit()]
        if len(digits) == 0:
            return -1
        digits = sorted(list(set(digits)))
        if len(digits) < 2:
            return -1
        return digits[-2]