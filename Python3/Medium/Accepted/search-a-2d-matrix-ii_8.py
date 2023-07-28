class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        if matrix == []:
            return False
        m = len(matrix)
        n = len(matrix[0])
        if matrix[0][0]>target or matrix[m-1][n-1]<target:
            return False
        i = 0
        j = n-1
        while i<m and j>=0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] > target:
                j-=1
            else:
                i+=1
        return False