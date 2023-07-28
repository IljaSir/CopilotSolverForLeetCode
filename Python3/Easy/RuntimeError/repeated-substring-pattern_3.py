class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        
        if s == "":
            return True
        for i in range(1, len(s)):
            if s[i] == s[0]:
                if self.is_substring(s, s[0:i+1]):
                    return True
        return False