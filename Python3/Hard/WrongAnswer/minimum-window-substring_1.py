class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s) < len(t):
            return ""
        if len(t) == 0:
            return ""
        if len(t) == 1:
            if t in s:
                return t
            else:
                return ""
        if len(s) == 1:
            return ""

        #s = "ADOBECODEBANC"
        #t = "ABC"
        #s = "a"
        #t = "aa"
        #s = "a"
        #t = "a"
        #s = "aa"
        #t = "aa"
        #