class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        d = {}
        for i in range(len(s)):
            if s[i] in d:
                d[s[i]] = -1
            else:
                d[s[i]] = i
        for i in range(len(s)):
            if d[s[i]] != -1:
                return d[s[i]]
        return -1