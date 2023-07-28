class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        
        if not s:
            return True
        if not t:
            return False
        t = iter(t)
        return all(char in t for char in s)