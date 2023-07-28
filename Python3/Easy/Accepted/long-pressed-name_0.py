class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        i = 0
        j = 0
        while i < len(name) and j < len(typed):
            if name[i] == typed[j]:
                i += 1
                j += 1
            else:
                if j > 0 and typed[j] == typed[j - 1]:
                    j += 1
                else:
                    return False
        if i < len(name):
            return False
        else:
            while j < len(typed):
                if typed[j] != typed[j - 1]:
                    return False
                j += 1
            return True