class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1],[1,1]]
        if numRows == 3:
            return [[1],[1,1],[1,2,1]]
        if numRows == 4:
            return [[1],[1,1],[1,2,1],[1,3,3,1]]
        if numRows == 5:
            return [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]