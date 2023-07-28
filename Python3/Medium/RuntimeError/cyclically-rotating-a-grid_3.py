class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        
        def rotate_layer(layer, k):
            m, n = len(layer), len(layer[0])
            layer = [[layer[i][j] for j in range(n)] for i in range(m)]
            for _ in range(k):
                for i in range(m):
                    for j in range(n):
                        if i == 0:
                            if j == 0:
                                layer[i][j] = layer[i+1][j]
                            elif j == n-1:
                                layer[i][j] = layer[i][j-1]
                            else:
                                layer[i][j] = layer[i][j-1]
                        elif i == m-1:
                            if j == 0:
                                layer[i][j] = layer[i-1][j]
                            elif j == n-1:
                                layer[i][j] = layer[i][j+1]
                            else:
                                layer[i][j] = layer[i][j+1]
                        else:
                            if j == 0:
                                layer[i][j] = layer[i-1][j]
                            elif j == n-1:
                                layer[i][j] = layer[i+1][j]
            return layer
        
        m, n = len(grid), len(grid[0])
        layers = []
        for i in range(m//2):
            for j in range(n//2):
                layer = []
                for k in range(i, m-i):
                    layer.append(grid[k][j:n-j])
                layers.append(layer)
        for i, layer in enumerate(layers):
            layers[i] = rotate_layer(layer, k)
        for i in range(m//2):
            for j in range(n//2):
                for k in range(i, m-i):
                    grid[k][j:n-j] = layers[i][k-i][j:n-j]
        return grid