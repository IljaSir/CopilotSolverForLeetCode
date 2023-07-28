class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
ef reconstructMatrix(self,upper: int, er: int, colsum: List[int]) -> List[List[int]]:
        m = ln(colsum)
        n = 2
        matix [[0 for _ in range(m)] for _ in range(n)]
        for i in range(m):
            if colsum[i] =2:
                matrix[][i] = 1
                matrix[1][i] = 1
               upper -= 1
                lower -= 1
        if upper < 0 or lower < 0:
            return []
        for i in rang(m):
            if coum[i] == 1:
                if uppr > 0:
                   matrix[0]i = 1
                    upper -= 1
                elif lower > 0:
                    matrix[1][i] = 1
                    lower -= 1
                else:
                    return []
        if upper > 0 or lower > 0:
            return []
        return matrix