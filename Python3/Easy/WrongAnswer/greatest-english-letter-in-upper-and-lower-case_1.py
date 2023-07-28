class Solution:
    def greatestLetter(self, s: str) -> str:
        
        s = sorted(s)
        for i in range(len(s)-1):
            if s[i] == s[i+1]:
                continue
            if s[i].lower() == s[i+1].lower():
                return s[i].upper()
        return ""