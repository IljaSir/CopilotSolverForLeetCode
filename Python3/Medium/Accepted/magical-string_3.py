class Solution:
    def magicalString(self, n: int) -> int:
        
        s = [1, 2, 2]
        i, j = 2, 2
        while len(s) < n:
            s += [3 - s[-1]] * s[j]
            j += 1
        return s[:n].count(1)