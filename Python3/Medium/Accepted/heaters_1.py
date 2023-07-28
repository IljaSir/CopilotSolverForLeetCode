class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        heaters = [float('-inf')] + heaters + [float('inf')]
        i = 0
        r = 0
        for house in houses:
            while house > heaters[i+1]:
                i += 1
            r = max(r, min(house - heaters[i], heaters[i+1] - house))
        return r