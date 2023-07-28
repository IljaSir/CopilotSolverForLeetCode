class Solution:
    def thousandSeparator(self, n: int) -> str:
        
        s = str(n)
        if len(s) < 4:
            return s
        return self.thousandSeparator(int(s[:-3])) + '.' + s[-3:]