class Solution:
    def lastSubstring(self, s: str) -> str:
        
        # print(s)
        if len(s) == 1:
            return s
        if len(s) == 2:
            if s[0] > s[1]:
                return s[0]
            else:
                return s[1]
        if s[0] > s[1]:
            return self.lastSubstring(s[1:])
        else:
            return self.lastSubstring(s[2:])