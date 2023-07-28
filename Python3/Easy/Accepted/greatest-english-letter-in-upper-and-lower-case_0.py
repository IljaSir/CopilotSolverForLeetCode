class Solution:
    def greatestLetter(self, s: str) -> str:
        
        s = set(s)
        for i in range(25, -1, -1):
            if chr(ord('A') + i) in s and chr(ord('a') + i) in s:
                return chr(ord('A') + i)
        return ""