class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        
        boxTypes.sort(key = lambda x: x[1], reverse = True)
        res = 0
        for i in range(len(boxTypes)):
            if truckSize == 0:
                break
            if truckSize >= boxTypes[i][0]:
                res += boxTypes[i][0] * boxTypes[i][1]
                truckSize -= boxTypes[i][0]
            else:
                res += truckSize * boxTypes[i][1]
                truckSize = 0
        return res