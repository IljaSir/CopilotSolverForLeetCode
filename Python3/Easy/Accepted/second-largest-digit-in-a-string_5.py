class Solution:
    def secondHighest(self, s: str) -> int:
        
        digits = [int(c) for c in s if c.isdigit()]
        return sorted(set(digits))[-2] if len(set(digits)) > 1 else -1