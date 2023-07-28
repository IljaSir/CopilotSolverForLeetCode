class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        res = [[rStart, cStart]]
        r, c = rStart, cStart
        d = 0
        dr = [0, 1, 0, -1]
        dc = [1, 0, -1, 0]
        while len(res) < rows * cols:
            if d == 0 or d == 2:
                steps = steps + 1
            for _ in range(steps):
                r += dr[d]
                c += dc[d]
                if 0 <= r < rows and 0 <= c < cols:
                    res.append([r, c])
            d = (d + 1) % 4
        return res