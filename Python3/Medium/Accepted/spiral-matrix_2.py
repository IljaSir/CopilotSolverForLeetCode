class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        direction_index = 0
        row, column = 0, 0
        result = []
        for _ in range(m * n):
            result.append(matrix[row][column])
            visited[row][column] = True
            next_row, next_column = row + directions[direction_index][0], column + directions[direction_index][1]
            if not (0 <= next_row < m and 0 <= next_column < n and not visited[next_row][next_column]):
                direction_index = (direction_index + 1) % 4
            row += directions[direction_index][0]
            column += directions[direction_index][1]
        return result