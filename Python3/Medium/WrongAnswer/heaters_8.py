class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        n = len(houses)
        m = len(heaters)
        i = 0
        j = 0
        res = 0
        while i < n:
            if j < m and houses[i] >= heaters[j]:
                j += 1
            if j == m:
                res = max(res, houses[i] - heaters[j-1])
                break
            if j == 0:
                res = max(res, heaters[j] - houses[i])
            else:
                res = max(res, min(houses[i] - heaters[j-1], heaters[j] - houses[i]))
            i += 1
        return res