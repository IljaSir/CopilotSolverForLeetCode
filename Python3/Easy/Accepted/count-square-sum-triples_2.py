class Solution:
    def countTriples(self, n: int) -> int:
        
        count = 0
        for a in range(1, n+1):
            for b in range(a, n+1):
                c = math.sqrt(a**2 + b**2)
                if c == int(c) and c <= n:
                    count += 2 if a != b else 1
        return count