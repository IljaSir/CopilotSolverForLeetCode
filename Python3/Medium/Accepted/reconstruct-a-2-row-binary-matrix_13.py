class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        n = len(colsum)
        ans = [[0]*n, [0]*n]
        for i, c in enumerate(colsum):
            if c == 2:
                ans[0][i] = ans[1][i] = 1
                upper -= 1
                lower -= 1
        if upper < 0 or lower < 0:
            return []
        for i, c in enumerate(colsum):
            if c == 1:
                if upper > 0:
                    ans[0][i] = 1
                    upper -= 1
                else:
                    ans[1][i] = 1
                    lower -= 1
        if upper == 0 and lower == 0:
            return ans
        else:
            return []