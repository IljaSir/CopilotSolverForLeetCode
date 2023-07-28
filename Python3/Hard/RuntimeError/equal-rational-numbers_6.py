class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        
        def parse_rational_number(s: str) -> float:
            if '(' in s:
                s = s.replace('(', '').replace(')', '')
            if '.' in s:
                s = s.replace('.'