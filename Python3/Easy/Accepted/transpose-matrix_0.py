class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        
        m = len(matrix)
        n = len(matrix[0])
        result = []
        for i in range(n):
            result.append([])
            for j in range(m):
                result[i].append(matrix[j][i])
        return result