class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        
        boxTypes.sort(key=lambda x: x[1], reverse=True)
        ans = 0
        for box, unit in boxTypes:
            if truckSize >= box:
                ans += box * unit
                truckSize -= box
            else:
                ans += truckSize * unit
                break
        return ans