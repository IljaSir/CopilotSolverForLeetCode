class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        ans = [[0]*len(colsum) for _ in range(2)]
        for i, x in enumerate(colsum):
            if x == 2:
                ans[0][i] = ans[1][i] = 1
                upper -= 1
                lower -= 1
        for i, x in enumerate(colsum):
            if x == 1:
                if upper > lower:
                    ans[0][i] = 1
                    upper -= 1
                else:
                    ans[1][i] = 1
                    lower -= 1
        return ans if upper == 0 and lower == 0 else []