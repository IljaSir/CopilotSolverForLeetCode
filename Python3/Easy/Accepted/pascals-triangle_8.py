class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows == 0:
            return []
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1], [1, 1]]
        pascal = [[1], [1, 1]]
        for i in range(2, numRows):
            row = [1]
            for j in range(len(pascal[i - 1]) - 1):
                row.append(pascal[i - 1][j] + pascal[i - 1][j + 1])
            row.append(1)
            pascal.append(row)
        return pascal