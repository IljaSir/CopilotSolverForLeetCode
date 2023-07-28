class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        return sorted([num for row in matrix for num in row])[k-1]