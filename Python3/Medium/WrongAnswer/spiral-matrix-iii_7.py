class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        def valid(r, c):
            return 0 <= r < rows and 0 <= c < cols
        def gen():
            r = rStart
            c = cStart
            yield r, c
            for i in range(1, max(rows, cols)):
                for _ in range(2):
                    for j in range(i):
                        c += 1
                        if valid(r, c):
                            yield r, c
                    for j in range(i):
                        r += 1
                        if valid(r, c):
                            yield r, c
        return list(gen())