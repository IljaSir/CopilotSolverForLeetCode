class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        if name == typed:
            return True
        if len(name) > len(typed):
            return False
        i = 0
        j = 0
        while i < len(name) and j < len(typed):
            if name[i] == typed[j]:
                i += 1
                j += 1
            else:
                if i == 0:
                    return False
                if name[i-1] == typed[j]:
                    j += 1
                else:
                    return False
        if i < len(name):
            return False
        if j < len(typed):
            for k in range(j, len(typed)):
                if typed[k] != name[-1]:
                    return False
        return True