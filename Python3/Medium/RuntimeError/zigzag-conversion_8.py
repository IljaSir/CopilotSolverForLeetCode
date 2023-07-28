class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        s_list = list(s)
        n = len(s_list)
        num_of_cols = n // 2 + 1
        matrix = [[''] * num_of_cols for _ in range(numRows)]
        i = 0
        j = 0
        direction = 1
        for char in s_list:
            matrix[i][j] = char
            if i == numRows - 1:
                direction = -1
            elif i == 0:
                direction = 1
            i += direction
            if direction == 1:
                j += 1
        result = ''
        for row in matrix:
            result += ''.join(row)
        return result