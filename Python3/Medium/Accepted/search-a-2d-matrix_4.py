class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        row = len(matrix)
        col = len(matrix[0])
        left = 0
        right = row * col - 1
        while left <= right:
            mid = (left + right) // 2
            if matrix[mid // col][mid % col] == target:
                return True
            if matrix[mid // col][mid % col] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False