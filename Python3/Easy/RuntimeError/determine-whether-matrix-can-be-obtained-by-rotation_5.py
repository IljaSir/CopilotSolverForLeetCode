class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        return any(mat == target for _ in range(4) for mat in [zip(*mat[::-1])])