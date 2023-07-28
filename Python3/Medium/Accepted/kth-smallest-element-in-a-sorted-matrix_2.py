class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        return sorted([j for i in matrix for j in i])[k-1]