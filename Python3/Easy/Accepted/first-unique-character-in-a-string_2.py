class Solution:
    def firstUniqChar(self, s: str) -> int:
        
        for i in range(len(s)):
            if s.find(s[i]) == s.rfind(s[i]):
                return i
        return -1