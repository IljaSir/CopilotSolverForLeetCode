class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        
        if len(changed) % 2 == 1:
            return []
        changed.sort()
        res = []
        while changed:
            x = changed.pop()
            if x % 2 == 1:
                return []
            y = x // 2
            if y not in changed:
                return []
            changed.remove(y)
            res.append(y)
        return res