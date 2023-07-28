class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        def neighbors(x, y):
            if grid[x][y] == "/":
                return [(x, y - 1), (x, y + 1), (x - 1, y), (x + 1, y)]
            elif grid[x][y] == "\\":
                return [(x, y - 1), (x, y + 1), (x - 1, y), (x + 1, y)]
            elif grid[x][y] == "(":
                return [(x, y - 1), (x, y + 1), (x - 1, y), (x + 1, y)]
            elif grid[x][y] == ")":
                return [(x, y - 1), (x, y + 1), (x - 1, y), (x + 1, y)]
            elif grid[x][y] == "-":
                return [(x, y - 1), (x, y + 1)]
            elif grid[x][y] == "|":
                return [(x - 1, y), (x + 1, y)]
        def valid(x, y):
            if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]):
                return False
            if grid[x][y] == "/":
                return True
            elif grid[x][y] == "\\":
                return True
            elif grid[x][y] == "(":
                return True
            elif grid[x][y] == ")":
                return True
            elif grid[x][y] == "-":
                return True
            elif grid[x][y] == "|":
                return True
        def dfs(x, y):
            if x == len(grid) - 1 and y == len(grid[0]) - 1:
                return True
            if (x, y) in visited:
                return False
            visited.add((x, y))
            for xx, yy in neighbors(x, y):
                if valid(xx, yy):
                    if dfs(xx, yy):
                        return True
            return False
        visited = set()
        return dfs(0, 0)