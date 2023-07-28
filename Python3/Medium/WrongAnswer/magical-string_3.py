class Solution:
    def magicalString(self, n: int) -> int:
        
        s = '122'
        i, j = 2, 2
        while len(s) < n:
            s += s[j] * int(s[i])
            i += 1
            j = len(s) - 1
        return s[:n].count('1')