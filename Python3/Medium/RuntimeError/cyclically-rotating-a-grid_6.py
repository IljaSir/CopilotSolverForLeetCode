class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        
        def rotate_layer(layer):
            n = len(layer)
            for i in range(n):
                for j in range(n):
                    new_i, new_j = j, n - i - 1
                    layer[i][j], layer[new_i][new_j] = layer[new_i][new_j], layer[i][j]
        
        def rotate_layer_k_times(layer, k):
            n = len(layer)
            k = k % (4 * (n - 1))
            for _ in range(k):
                rotate_layer(layer)
        
        def get_layer(grid, layer):
            n = len(grid)
            m = len(grid[0])
            layer_grid = [[0 for _ in range(m)] for _ in range(n)]
            for i in range(n):
                for j in range(m):
                    if i == layer or j == layer or i == n - layer - 1 or j == m - layer - 1:
                        layer_grid[i][j] = grid[i][j]
            return layer_grid
        
        def get_layer_k(grid, layer, k):
            n = len(grid)
            m = len(grid[0])
            layer_grid = get_layer(grid, layer)
            rotate_layer_k_times(layer_grid, k)
            return layer_grid
        
        def get_grid_from_layer(layer_grid, layer):
            n = len(layer_grid)
            m = len(layer_grid[0])
            grid = [[0 for _ in range(m)] for _ in range(n)]
            for i in range(n):
                for j in range(m):
                    if i == layer or j == layer or i == n - layer - 1 or j == m - layer - 1:
                        grid[i][j] = layer_grid[i][j]
            return grid
        
        def get_grid_from_layer_k(layer_grid, layer):
            n = len(layer_grid)
            m = len(layer_grid[0])
            grid = [[0 for _ in range(m)] for _ in range(n)]
            for i in range(n):
                for j in range(m):
                    if i == layer or j == layer or i == n - layer - 1 or j == m - layer - 1:
                        grid[i][j] = layer_grid[i][j]
            return grid
        
        def get_grid(grid, k):
            n = len(grid)
            m = len(grid[0])
            res = [[0 for _