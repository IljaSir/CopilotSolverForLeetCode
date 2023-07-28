class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        # 1. binary search
        # 2. convert 2d to 1d
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m * n - 1
        while l <= r:
            mid = (l + r) // 2
            mid_element = matrix[mid // n][mid % n]
            if target == mid_element:
                return True
            elif target < mid_element:
                r = mid - 1
            else:
                l = mid + 1
        return False