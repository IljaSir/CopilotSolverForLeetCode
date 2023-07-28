class Solution:
    def lastSubstring(self, s: str) -> str:
        
        n = len(s)
        i = 0
        j = 1
        k = 0
        while j+k < n:
            if s[i+k] == s[j+k]:
                k += 1
            elif s[i+k] < s[j+k]:
                i = j
                j += 1
                k = 0
            elif s[i+k] > s[j+k]:
                j += k+1
                k = 0
        return s[i:]