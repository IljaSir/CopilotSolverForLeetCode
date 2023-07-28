class Solution:
    def lastSubstring(self, s: str) -> str:
        
        n = len(s)
        if n == 1:
            return s
        i = 1
        while i < n:
            if s[i] > s[0]:
                return self.lastSubstring(s[i:])
            if s[i] == s[0]:
                j = 1
                while j < n - i:
                    if s[i + j] > s[j]:
                        return self.lastSubstring(s[i:])
                    if s[i + j] < s[j]:
                        break
                    j += 1
            i += 1
        return s