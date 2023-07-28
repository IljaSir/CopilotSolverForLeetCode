class Solution:
    def thousandSeparator(self, n: int) -> str:
        
        if n < 1000:
            return str(n)
        else:
            n = str(n)
            n = n[::-1]
            n = '.'.join([n[i:i+3] for i in range(0, len(n), 3)])
            return n[::-1]