class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        
        if len(changed) % 2 == 1:
            return []
        changed.sort()
        original = []
        while changed:
            if changed[0] == 0:
                if len(changed) % 2 == 1:
                    return []
                else:
                    return original
            if changed[0] * 2 in changed:
                original.append(changed[0])
                changed.remove(changed[0])
                changed.remove(changed[0] * 2)
            else:
                return []
        return original