class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        
        n, t = len(name), len(typed)
        i, j = 0, 0
        while i < n and j < t:
            if name[i] == typed[j]:
                i += 1
                j += 1
            else:
                if j == 0 or typed[j] != typed[j-1]:
                    return False
                j += 1
        if i != n:
            return False
        while j < t:
            if typed[j] != typed[j-1]:
                return False
            j += 1
        return True