class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        def check(x, y):
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]):
                return False
            if grid[x][y] == ' ':
                return False
            if grid[x][y] == '1':
                if grid[x][y-1] == '1' or grid[x][y-1] == '4':
                    return True
            if grid[x][y] == '2':
                if grid[x][y+1] == '2' or grid[x][y+1] == '3':
                    return True
            if grid[x][y] == '3':
                if grid[x-1][y] == '3' or grid[x-1][y] == '2':
                    return True
            if grid[x][y] == '4':
                if grid[x+1][y] == '4' or grid[x+1][y] == '1':
                    return True
            return False
        queue = [(0, 0)]
        grid[0][0] = ' '
        while queue:
            x, y = queue.pop(0)
            if x == len(grid) - 1 and y == len(grid[0]) - 1:
                return True
            if check(x+1, y):
                queue.append((x+1, y))
                grid[x+1][y] = ' '
            if check(x-1, y):
                queue.append((x-1, y))
                grid[x-1][y] = ' '
            if check(x, y+1):
                queue.append((x, y+1))
                grid[x][y+1] = ' '
            if check(x, y-1):
                queue.append((x, y-1))
                grid[x][y-1] = ' '
        return False