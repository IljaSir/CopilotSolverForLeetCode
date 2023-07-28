class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        
        if s1 == s2:
            return True
        n = len(s1)
        diff = []
        for i in range(n):
            if s1[i] != s2[i]:
                diff.append(i)
        if len(diff) != 2:
            return False
        i, j = diff
        return s1[i] == s2[j] and s1[j] == s2[i]