class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1], [1, 1]]
        result = [[1], [1, 1]]
        for i in range(3, numRows + 1):
            temp = [1]
            for j in range(0, i - 2):
                temp.append(result[i - 2][j] + result[i - 2][j + 1])
            temp.append(1)
            result.append(temp)
        return result