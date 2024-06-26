class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        
        if len(s) == 0:
            return True
        if len(t) == 0:
            return False
        index = 0
        for i in range(len(t)):
            if s[index] == t[i]:
                index += 1
            if index == len(s):
                return True
        return False