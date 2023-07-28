class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        
        if len(changed) % 2 == 1:
            return []
        changed.sort()
        i = 0
        while i < len(changed):
            if changed[i] == 0:
                if i + 1 < len(changed) and changed[i + 1] == 0:
                    i += 2
                else:
                    return []
            else:
                if i + 1 < len(changed) and changed[i + 1] == changed[i] * 2:
                    i += 2
                else:
                    return []
        return changed