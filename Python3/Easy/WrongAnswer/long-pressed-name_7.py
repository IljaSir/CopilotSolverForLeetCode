class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        if len(typed) < len(name):
            return False
        i = 0
        j = 0
        while i < len(name):
            if j >= len(typed):
                return False
            if name[i] == typed[j]:
                i += 1
                j += 1
            else:
                if j > 0 and typed[j] == typed[j-1]:
                    j += 1
                else:
                    return False
        return True