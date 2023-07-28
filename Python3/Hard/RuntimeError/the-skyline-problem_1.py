class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        if not buildings:
            return []
        if len(buildings) == 1:
            return [[buildings[0][0], buildings[0][2]], [buildings[0][1], 0]]
        
        mid = len(buildings) // 2
        left = self.getSkyline(buildings[:mid])
        right = self.getSkyline(buildings[mid:])
        
        return self.merge(left, right)