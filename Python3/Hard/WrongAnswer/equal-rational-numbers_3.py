class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        
        def get_num(s):
            if '(' in s:
                i = s.index('(')
                return float(s[:i]) + float(s[i+1:-1]) / (10 ** (len(s) - i - 2))
            else:
                return float(s)
        
        return get_num(s) == get_num(t)