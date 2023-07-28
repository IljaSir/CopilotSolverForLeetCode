class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        # upper + lower = colsum
        # upper + lower == 0
        # upper + lower == 1
        # upper + lower == 2
        # upper + lower > 2
        # upper + 2*lower == 2
        # upper + 2*lower == 1
        # upper + 2*lower == 0
        # upper + 2*lower > 2
        # upper*lower != 0
        # upper*lower == 0
        n = len(colsum)
        if upper + lower != sum(colsum):
            return []
        if upper*lower != 0:
            return []
        if upper + 2*lower > 2*n:
            return []
        if upper + 2*lower < 2*n:
            return []
        if upper + lower > 2*n:
            return []
        if upper + lower < 2*n:
            return []
        if upper + 2*lower == 2*n:
            return [[1]*n, [1]*n]
        if upper + 2*lower == 2*n:
            return [[0]*n, [0]*n]
        if upper + 2*lower == 1*n:
            return [[0]*n, [1]*n]
        if upper + 2*lower == 0*n:
            return [[1]*n, [0]*n]
        if upper + lower == 2*n:
            return [[1]*n, [1]*n]
        if upper + lower == 1*n:
            return [[0]*n, [1]*n]
        if upper + lower == 0*n:
            return [[1]*n, [0]*n]
        if upper + lower > 2*n:
            return []
        if upper + 2*lower == 2*n:
            return [[1]*n, [1]*n]
        if upper + 2*lower == 1*n:
            return [[0]*n, [1]*n]
        if upper + 2*lower == 0*n:
            return [[1]*n, [0]*n]
        if upper + 2*lower > 2*n:
            return []
        if upper + lower > 2*n:
            return []
        if upper + lower < 2*n:
            return []
        if upper