class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        n = len(colsum)
        res = [[0]*n, [0]*n]
        for i, s in enumerate(colsum):
            if s == 2:
                res[0][i] = res[1][i] = 1
                upper -= 1
                lower -= 1
        if upper < 0 or lower < 0:
            return []
        for i, s in enumerate(colsum):
            if s == 1:
                if upper > 0:
                    res[0][i] = 1
                    upper -= 1
                elif lower > 0:
                    res[1][i] = 1
                    lower -= 1
                else:
                    return []
        return res if upper == 0 and lower == 0 else []