class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        for i in range(min(m, n) // 2):
            temp = []
            for j in range(i, n - i - 1):
                temp.append(grid[i][j])
            for j in range(i, m - i - 1):
                temp.append(grid[j][n - i - 1])
            for j in range(n - i - 1, i, -1):
                temp.append(grid[m - i - 1][j])
            for j in range(m - i - 1, i, -1):
                temp.append(grid[j][i])
            k = k % len(temp)
            for j in range(i, n - i - 1):
                grid[i][j] = temp[(j - i - k) % len(temp)]
            for j in range(i, m - i - 1):
                grid[j][n - i - 1] = temp[(j - i - k) % len(temp) + n - 2 * i - 2]
            for j in range(n - i - 1, i, -1):
                grid[m - i - 1][j] = temp[(j - i - k) % len(temp) + 2 * (n - 2 * i - 2)]
            for j in range(m - i - 1, i, -1):
                grid[j][i] = temp[(j - i - k) % len(temp) + 2 * (n - 2 * i - 2) + m - 2 * i - 2]
        return grid