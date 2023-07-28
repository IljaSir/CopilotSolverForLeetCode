class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        grid = [[0] * n for _ in range(n)]
        for i, j, x, y in queries:
            for a in range(i, x + 1):
                for b in range(j, y + 1):
                    grid[a][b] += 1
        return grid