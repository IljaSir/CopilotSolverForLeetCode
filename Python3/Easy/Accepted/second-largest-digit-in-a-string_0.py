class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = []
        for c in s:
            if c.isdigit():
                if c not in digits:
                    digits.append(c)
        if len(digits) < 2:
            return -1
        digits.sort(reverse=True)
        return int(digits[1])