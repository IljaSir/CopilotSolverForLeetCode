class Solution:
    def surfaceArea(self, grid: List[List[int]]) -> int:
        
        
        # 1. Get the number of cubes
        # 2. Get the number of cubes that are touching
        # 3. Get the number of cubes that are touching the bottom or top
        # 4. Get the number of cubes that are touching the side
        # 5. Return the total surface area

        # 1. Get the number of cubes
        number_of_cubes = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                number_of_cubes += grid[i][j]
                
        # 2. Get the number of cubes that are touching
        number_of_cubes_touching = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] > 1:
                    number_of_cubes_touching += grid[i][j] - 1
                if i < len(grid) - 1:
                    if grid[i][j] > 0 and grid[i + 1][j] > 0:
                        number_of_cubes_touching += min(grid[i][j], grid[i + 1][j])
                if j < len(grid[i]) - 1:
                    if grid[i][j] > 0 and grid[i][j + 1] > 0:
                        number_of_cubes_touching += min(grid[i][j], grid[i][j + 1])
        
        # 3. Get the number of cubes that are touching the bottom or top
        number_of_cubes_touching_bottom_or_top = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] > 0:
                    number_of_cubes_touching_bottom_or_top += 2
        
        # 4. Get the number of cubes that are touching the side
        number_of_cubes_touching_side = number_of_cubes * 6 - number_of_cubes_touching * 2 - number_of_cubes_touching_bottom_or_top
        
        # 5. Return the total surface area
        return number_of_cubes_touching_side