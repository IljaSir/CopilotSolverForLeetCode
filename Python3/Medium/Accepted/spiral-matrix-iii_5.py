class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        def next_pos(x, y, d, step):
            if d == 0: return x, y+step
            if d == 1: return x+step, y
            if d == 2: return x, y-step
            if d == 3: return x-step, y
        res = []
        x, y = rStart, cStart
        step = 0
        d = 0
        while len(res) < rows*cols:
            step += 1
            for _ in range(2):
                for _ in range(step):
                    if 0 <= x < rows and 0 <= y < cols:
                        res.append([x, y])
                    x, y = next_pos(x, y, d, 1)
                d = (d+1) % 4
        return res