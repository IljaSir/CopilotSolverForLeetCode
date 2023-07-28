class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        i, j = 0, 0
        result = []
        while m > 0 and n > 0:
            # if one row/column left, no circle can be formed
            if m == 1:
                for _ in range(n):
                    result.append(matrix[i][j])
                    j += 1
                break
            elif n == 1:
                for _ in range(m):
                    result.append(matrix[i][j])
                    i += 1
                break
            # below, process a circle
            # top - move right
            for _ in range(n-1):
                result.append(matrix[i][j])
                j += 1
            # right - move down
            for _ in range(m-1):
                result.append(matrix[i][j])
                i += 1
            # bottom - move left
            for _ in range(n-1):
                result.append(matrix[i][j])
                j -= 1
            # left - move up
            for _ in range(m-1):
                result.append(matrix[i][j])
                i -= 1
            i += 1
            j += 1
            m -= 2
            n -= 2
        return result