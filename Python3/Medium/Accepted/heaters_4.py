class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        heaters = [-float('inf')] + heaters + [float('inf')]
        i = 0
        ans = 0
        for house in houses:
            while house > heaters[i+1]:
                i += 1
            ans = max(ans, min(house - heaters[i], heaters[i+1] - house))
        return ans