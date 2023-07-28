class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        layers = min(m, n) // 2
        for layer in range(layers):
            m, n = m - 2, n - 2
            tmp = []
            for i in range(layer, layer + m):
                tmp.append(grid[i][layer])
            for j in range(layer, layer + n):
                tmp.append(grid[layer + m][j])
            for i in reversed(range(layer, layer + m)):
                tmp.append(grid[i][layer + n])
            for j in reversed(range(layer, layer + n)):
                tmp.append(grid[layer][j])
            k %= len(tmp)
            tmp = tmp[k:] + tmp[:k]
            for i in range(layer, layer + m):
                grid[i][layer] = tmp.pop(0)
            for j in range(layer, layer + n):
                grid[layer + m][j] = tmp.pop(0)
            for i in reversed(range(layer, layer + m)):
                grid[i][layer + n] = tmp.pop(0)
            for j in reversed(range(layer, layer + n)):
                grid[layer][j] = tmp.pop(0)
        return grid