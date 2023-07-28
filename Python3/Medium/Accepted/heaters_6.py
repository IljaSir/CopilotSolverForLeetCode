class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        n = len(houses)
        m = len(heaters)
        i, j = 0, 0
        ans = 0
        while i < n:
            while j + 1 < m and abs(heaters[j + 1] - houses[i]) <= abs(heaters[j] - houses[i]):
                j += 1
            ans = max(ans, abs(heaters[j] - houses[i]))
            i += 1
        return ans