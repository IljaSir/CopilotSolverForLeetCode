class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        for i in range(4):
            if mat == target:
                return True
            mat = list(zip(*mat[::-1]))
        return False