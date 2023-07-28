class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        def parse(s):
            if '(' not in s:
                return int(s), 0, 0
            i = s.index('(')
            return int(s[:i]), int(s[i+1:-1]), len(s) - i - 2
        a, b, c = parse(s)
        x, y, z = parse(t)
        return a * y * z + b * x * z == x * b * c + y * a * c