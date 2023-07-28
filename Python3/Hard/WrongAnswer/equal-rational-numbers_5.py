class Solution:
    def isRationalEqual(self, s: str, t: str) -> bool:
        
        # print(s, t)
        def get_num(s):
            if '(' in s:
                a, b = s.split('(')
                b = b[:-1]
                return a + b
            else:
                return s
        def get_den(s):
            if '(' in s:
                a, b = s.split('(')
                b = b[:-1]
                return a[:-1] + b * 20
            else:
                return s[:-1]
        return get_num(s) == get_num(t) and get_den(s) == get_den(t)