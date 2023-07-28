class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        res = [[rStart, cStart]]
        r, c = rStart, cStart
        d = 0
        l = 1
        while len(res) < rows * cols:
            for _ in range(l):
                c += 1
                if 0 <= r < rows and 0 <= c < cols:
                    res.append([r, c])
            for _ in range(l):
                r += 1
                if 0 <= r < rows and 0 <= c < cols:
                    res.append([r, c])
            l += 1
            for _ in range(l):
                c -= 1
                if 0 <= r < rows and 0 <= c < cols:
                    res.append([r, c])
            for _ in range(l):
                r -= 1
                if 0 <= r < rows and 0 <= c < cols:
                    res.append([r, c])
            l += 1
        return res