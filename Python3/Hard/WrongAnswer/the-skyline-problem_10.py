class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        # sort the buildings by x
        buildings.sort(key=lambda x: x[0])
        # init the heap
        heap = [[0, float('inf')]]
        return #esult