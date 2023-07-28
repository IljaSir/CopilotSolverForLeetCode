class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        n = len(colsum)
        row1 = [0]*n
        row2 = [0]*n
        for i in range(n):
            if colsum[i] == 2:
                row1[i] = 1
                row2[i] = 1
                upper -= 1
                lower -= 1
        if upper < 0 or lower < 0:
            return []
        for i in range(n):
            if colsum[i] == 1:
                if upper > 0:
                    row1[i] = 1
                    upper -= 1
                elif lower > 0:
                    row2[i] = 1
                    lower -= 1
                else:
                    return []
        if upper != 0 or lower != 0:
            return []
        return [row1, row2]