class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        
        # n = len(grid)
        # m = len(grid[0])
        # count = 0
        # for i in range(n):
        #     for j in range(m):
        #         if grid[i][j] < 0:
        #             count += 1
        # return count
        # n = len(grid)
        # m = len(grid[0])
        # count = 0
        # for i in range(n):
        #     for j in range(m):
        #         if grid[i][j] < 0:
        #             count += m - j
        #             break
        # return count
        n = len(grid)
        m = len(grid[0])
        count = 0
        j = m - 1
        for i in range(n):
            while j >= 0 and grid[i][j] < 0:
                j -= 1
            count += m - j - 1
        return count