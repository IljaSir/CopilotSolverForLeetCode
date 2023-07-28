class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        n = len(matrix)
        lo, hi = matrix[0][0], matrix[n-1][n-1]
        while lo <= hi:
            mid = (lo + hi) // 2
            count = self.count(matrix, mid)
            if count < k:
                lo = mid + 1
            else:
                hi = mid - 1
        return lo