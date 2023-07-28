class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        if n < 3:
            return 0
        if n == 3:
            return 1 if forts[0] == forts[2] == 0 else 0
        if forts.count(1) == 0:
            return 0
        if forts.count(1) == 1:
            return 2 if forts.index(1) in (0, n - 1) else 1
        if forts.count(1) == 2:
            return 3 if forts.index(1) == 0 or forts.index(1, forts.index(1) + 1) == n - 1 else 2
        l, r = 0, n - 1
        while forts[l] == 0:
            l += 1
        while forts[r] == 0:
            r -= 1
        return r - l + 1