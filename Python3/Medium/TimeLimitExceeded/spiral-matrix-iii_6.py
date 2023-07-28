class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        res = [[rStart, cStart]]
        n = rows * cols
        d = 0
        i = 0
        while len(res) < n:
            if d == 0:
                cStart += 1
            elif d == 1:
                rStart += 1
            elif d == 2:
                cStart -= 1
            else:
                rStart -= 1
            i += 1
            if 0 <= rStart < rows and 0 <= cStart < cols:
                res.append([rStart, cStart])
            if i == 1:
                d = (d + 1) % 4
                i = 0
            if d % 2 == 0:
                i += 1
        return res