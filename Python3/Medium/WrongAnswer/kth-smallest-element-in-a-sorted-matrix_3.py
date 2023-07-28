class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        if k == n**2:
            return matrix[-1][-1]
        if k == 1:
            return matrix[0][0]
        if k == n:
            return matrix[0][-1]
        if k == n*(n-1)+1:
            return matrix[-1][0]
        low, high = matrix[0][0], matrix[-1][-1]
        while low < high:
            mid = (low + high) // 2
            count = 0
            for i in range(n):
                for j in range(n):
                    if matrix[i][j] <= mid:
                        count += 1
            if count < k:
                low = mid + 1
            else:
                high = mid
        return low