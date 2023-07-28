class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        
        res = []
        for i in range(len(grid) - 2):
            res.append([])
            for j in range(len(grid[i]) - 2):
                res[i].append(max([max([grid[i+x][j+y] for y in range(3)]) for x in range(3)]))
        return res