class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        res = []
        i, j = 0, 0
        while len(res) < m * n:
            while j < n and matrix[i][j] is not None:
                res.append(matrix[i][j])
                matrix[i][j] = None
                j += 1
            j -= 1
            i += 1
            while i < m and matrix[i][j] is not None:
                res.append(matrix[i][j])
                matrix[i][j] = None
                i += 1
            i -= 1
            j -= 1
            while j >= 0 and matrix[i][j] is not None:
                res.append(matrix[i][j])
                matrix[i][j] = None
                j -= 1
            j += 1
            i -= 1
            while i >= 0 and matrix[i][j] is not None:
                res.append(matrix[i][j])
                matrix[i][j] = None
                i -= 1
            i += 1
            j += 1
        return res