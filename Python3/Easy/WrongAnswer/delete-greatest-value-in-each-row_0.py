class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        
        result = 0
        while grid:
            max_row = 0
            for i in range(len(grid)):
                max_row = max(max_row, max(grid[i]))
            result += max_row
            for i in range(len(grid)):
                if max_row in grid[i]:
                    grid[i].remove(max_row)
            grid = [row for row in grid if row]
        return result