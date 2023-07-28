class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(' ', '')
        def calc(s, op):
            n = 0
            ans = 0
            for c in s:
                if c.isdigit():
                    n = n*10 + int(c)
                elif c == op:
                    ans += n
                    n = 0
            ans += n
            return ans
        s = str(calc(s, '+'))
        s = str(calc(s, '-'))
        s = str(calc(s, '*'))
        s = str(calc(s, '/'))
        return int(s)