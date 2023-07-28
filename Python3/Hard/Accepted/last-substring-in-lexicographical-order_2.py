class Solution:
    def lastSubstring(self, s: str) -> str:
        
        n = len(s)
        if n == 1:
            return s
        i = 0
        j = 1
        k = 0
        while j + k < n:
            if s[i+k] == s[j+k]:
                k += 1
                continue
            if s[i+k] > s[j+k]:
                j += k + 1
            else:
                i = max(i+k+1, j)
                j = i + 1
            k = 0
        return s[i:]