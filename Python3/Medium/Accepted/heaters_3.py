class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        
        houses.sort()
        heaters.sort()
        i = 0
        ans = 0
        for house in houses:
            while i < len(heaters)-1 and abs(heaters[i]-house) >= abs(heaters[i+1]-house):
                i += 1
            ans = max(ans, abs(heaters[i]-house))
        return ans