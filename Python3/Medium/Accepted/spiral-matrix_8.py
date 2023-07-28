class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        m, n = len(matrix), len(matrix[0])
        steps = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        step_index = 0
        res = []
        i, j = 0, 0
        for _ in range(m * n):
            res.append(matrix[i][j])
            matrix[i][j] = None
            next_i, next_j = i + steps[step_index][0], j + steps[step_index][1]
            if 0 <= next_i < m and 0 <= next_j < n and matrix[next_i][next_j] is not None:
                i, j = next_i, next_j
            else:
                step_index = (step_index + 1) % 4
                i, j = i + steps[step_index][0], j + steps[step_index][1]
        return res