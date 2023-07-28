class Solution:
    def calculate(self, s: str) -> int:
        
        s = s.replace(' ', '')
        s = s.replace('-', '+-')
        s = s.split('+')
        s = [int(i) for i in s if i]
        res = s[0]
        for i in range(1, len(s)):
            res -= s[i]
        return res