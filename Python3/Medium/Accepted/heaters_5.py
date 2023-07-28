class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        n, m = len(houses), len(heaters)
        ans = 0
        i = 0
        for house in houses:
            while i < m - 1 and heaters[i] + heaters[i + 1] <= house * 2:
                i += 1
            ans = max(ans, abs(heaters[i] - house))
        return ans