class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        ans = [[rStart, cStart]]
        r, c, d = rStart, cStart, 0
        step = 0
        while len(ans) < rows * cols:
            if d == 0 or d == 2:
                step += 1
            for _ in range(step):
                r += direction[d][0]
                c += direction[d][1]
                if 0 <= r < rows and 0 <= c < cols:
                    ans.append([r, c])
            d = (d + 1) % 4
        return ans