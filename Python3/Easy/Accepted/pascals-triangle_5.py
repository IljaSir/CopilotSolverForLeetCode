class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1], [1, 1]]
        result = [[1], [1, 1]]
        for i in range(3, numRows + 1):
            row = [1]
            for j in range(1, i - 1):
                row.append(result[i - 2][j - 1] + result[i - 2][j])
            row.append(1)
            result.append(row)
        return result