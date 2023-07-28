class Solution:
    def makeFancyString(self, s: str) -> str:
        
        s = [c for c in s]
        i = 1
        while i < len(s) - 1:
            if s[i-1] == s[i] == s[i+1]:
                s.pop(i)
            else:
                i += 1
        return ''.join(s)