class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])
        result = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m // 2):
            for j in range(n // 2):
                temp = []
                for x in range(i, m - i - 1):
                    temp.append(grid[x][j])
                for x in range(j, n - j - 1):
                    temp.append(grid[m - i - 1][x])
                for x in range(m - i - 1, i, -1):
                    temp.append(grid[x][n - j - 1])
                for x in range(n - j - 1, j, -1):
                    temp.append(grid[i][x])
                temp = temp[k:] + temp[:k]
                index = 0
                for x in range(i, m - i - 1):
                    result[x][j] = temp[index]
                    index += 1
                for x in range(j, n - j - 1):
                    result[m - i - 1][x] = temp[index]
                    index += 1
                for x in range(m - i - 1, i, -1):
                    result[x][n - j - 1] = temp[index]
                    index += 1
                for x in range(n - j - 1, j, -1):
                    result[i][x] = temp[index]
                    index += 1
        return result