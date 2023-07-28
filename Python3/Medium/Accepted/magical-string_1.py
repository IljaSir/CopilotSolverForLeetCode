class Solution:
    def magicalString(self, n: int) -> int:
        
        s = '122'
        i = 2
        while len(s) < n:
            s += str(3 - int(s[-1])) * int(s[i])
            i += 1
        return s[:n].count('1')