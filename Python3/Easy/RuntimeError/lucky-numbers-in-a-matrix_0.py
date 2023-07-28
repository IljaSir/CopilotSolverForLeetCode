class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        
        #return [min(row) for row in matrix if max(col) == min(row) for col in zip(*matrix)]
        return [min(row) for row in matrix if max(col) == min(row) for col in zip(*matrix)]