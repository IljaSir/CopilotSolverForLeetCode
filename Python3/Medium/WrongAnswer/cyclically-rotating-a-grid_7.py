class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        
        def rotate_layer(layer, k):
            # print(layer)
            n = len(layer)
            k %= n
            if k == 0:
                return layer
            return layer[n-k:] + layer[:n-k]
        
        def get_layer(grid, layer):
            m, n = len(grid), len(grid[0])
            if layer >= min(m, n) // 2:
                return []
            layer_grid = []
            for i in range(layer, m-layer):
                layer_grid.append(grid[i][layer])
            for j in range(layer+1, n-layer):
                layer_grid.append(grid[m-layer-1][j])
            for i in range(m-layer-2, layer-1, -1):
                layer_grid.append(grid[i][n-layer-1])
            for j in range(n-layer-2, layer, -1):
                layer_grid.append(grid[layer][j])
            return layer_grid
        
        def set_layer(grid, layer, layer_grid):
            m, n = len(grid), len(grid[0])
            if layer >= min(m, n) // 2:
                return
            i = layer
            for j in range(layer, n-layer):
                grid[i][j] = layer_grid.pop(0)
            j = n-layer-1
            for i in range(layer+1, m-layer):
                grid[i][j] = layer_grid.pop(0)
            i = m-layer-1
            for j in range(n-layer-2, layer-1, -1):
                grid[i][j] = layer_grid.pop(0)
            j = layer
            for i in range(m-layer-2, layer, -1):
                grid[i][j] = layer_grid.pop(0)
        
        m, n = len(grid), len(grid[0])
        for layer in range(min(m, n) // 2):
            layer_grid = get_layer(grid, layer)
            layer_grid = rotate_layer(layer_grid, k)
            set_layer(grid, layer, layer_grid)
        return grid