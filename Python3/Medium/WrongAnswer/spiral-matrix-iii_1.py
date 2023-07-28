class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        res = [[rStart, cStart]]
        x, y = rStart, cStart
        for d in range(1, 2 * (rows + cols)):
            for i in range(d // 2 + 1):
                x += dirs[d % 4][0]
                y += dirs[d % 4][1]
                if 0 <= x < rows and 0 <= y < cols:
                    res.append([x, y])
        return res