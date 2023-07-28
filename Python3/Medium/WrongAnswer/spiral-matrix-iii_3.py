class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        def spiral(r, c):
            for dx, dy in ((0, 1), (1, 0), (0, -1), (-1, 0)):
                for _ in range((r + c) % 2 + 1):
                    if 0 <= r < rows and 0 <= c < cols:
                        yield r, c
                    r, c = r + dx, c + dy
        return list(islice(spiral(rStart, cStart), rows * cols))