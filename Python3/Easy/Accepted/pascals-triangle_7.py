class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1], [1, 1]]
        result = [[1], [1, 1]]
        for i in range(1, numRows - 1):
            temp = [1]
            for j in range(len(result[i]) - 1):
                temp.append(result[i][j] + result[i][j + 1])
            temp.append(1)
            result.append(temp)
        return result