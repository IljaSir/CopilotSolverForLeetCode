class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        def get(n):
            i = n.find('(')
            if i >= 0:
                n = n[:i] + n[i+1:-1] * 20
            return float(n)
        return get(s) == get(t)