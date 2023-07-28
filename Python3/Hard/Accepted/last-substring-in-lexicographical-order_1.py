class Solution:
    def lastSubstring(self, s: str) -> str:
        
        i = 0
        j = 1
        k = 0
        while i+k < len(s) and j+k < len(s):
            if s[i+k] == s[j+k]:
                k += 1
            elif s[i+k] > s[j+k]:
                j = j+k+1
                k = 0
            else:
                i = max(i+k+1, j)
                j = i+1
                k = 0
        return s[i:]