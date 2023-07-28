class Solution:
    def isValid(self, s: str) -> bool:
        
        if len(s) % 3 != 0:
            return False
        while "abc" in s:
            s = s.replace("abc", "")
        return s == ""