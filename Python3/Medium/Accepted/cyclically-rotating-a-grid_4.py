class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        
        def rotate(grid, k):
            m = len(grid)
            n = len(grid[0])
            for i in range(min(m, n) // 2):
                layer = []
                for j in range(i, n - i):
                    layer.append(grid[i][j])
                for j in range(i + 1, m - i):
                    layer.append(grid[j][n - i - 1])
                for j in range(n - i - 2, i - 1, -1):
                    layer.append(grid[m - i - 1][j])
                for j in range(m - i - 2, i, -1):
                    layer.append(grid[j][i])
                layer = layer[k % len(layer):] + layer[:k % len(layer)]
                idx = 0
                for j in range(i, n - i):
                    grid[i][j] = layer[idx]
                    idx += 1
                for j in range(i + 1, m - i):
                    grid[j][n - i - 1] = layer[idx]
                    idx += 1
                for j in range(n - i - 2, i - 1, -1):
                    grid[m - i - 1][j] = layer[idx]
                    idx += 1
                for j in range(m - i - 2, i, -1):
                    grid[j][i] = layer[idx]
                    idx += 1
            return grid
        
        return rotate(grid, k)