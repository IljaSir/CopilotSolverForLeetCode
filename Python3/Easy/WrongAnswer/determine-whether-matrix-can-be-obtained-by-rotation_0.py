class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        for _ in range(4):
            mat = list(zip(*mat[::-1]))
            if mat == target:
                return True
        return False