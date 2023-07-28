class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        
        n = len(colsum)
        a = [0]*n
        b = [0]*n
        for i in range(n):
            if colsum[i] == 2:
                a[i] = 1
                b[i] = 1
                upper -= 1
                lower -= 1
        for i in range(n):
            if colsum[i] == 1:
                if upper > 0:
                    a[i] = 1
                    upper -= 1
                elif lower > 0:
                    b[i] = 1
                    lower -= 1
        if upper == 0 and lower == 0:
            return [a,b]
        else:
            return []