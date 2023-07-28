class Solution:
    def minimumRefill(self, plants: List[int], capacityA: int, capacityB: int) -> int:
        
        n = len(plants)
        i, j = 0, n-1
        res = 0
        a, b = 0, 0
        while i <= j:
            if a < plants[i]:
                a = capacityA
                res += 1
            a -= plants[i]
            i += 1
            if i > j:
                break
            if b < plants[j]:
                b = capacityB
                res += 1
            b -= plants[j]
            j -= 1
        return res