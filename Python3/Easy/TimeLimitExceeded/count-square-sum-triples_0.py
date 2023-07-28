class Solution:
    def countTriples(self, n: int) -> int:
        
        return sum([1 for a in range(1, n+1) for b in range(1, n+1) for c in range(1, n+1) if a**2 + b**2 == c**2])