class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        
        
        # 1. Check if grid is valid
        n = len(grid)
        if n < 3 or n > 7:
            return False
        
        # 2. Check if grid has all unique integers
        all_numbers = []
        for row in grid:
            for number in row:
                if number in all_numbers:
                    return False
                else:
                    all_numbers.append(number)
        
        # 3. Check if grid has all integers from 0 to n*n-1
        for i in range(n*n):
            if i not in all_numbers:
                return False
        
        # 4. Check if grid has valid knight moves
        directions = [[-2, -1], [-2, 1], [2, -1], [2, 1], [-1, -2], [-1, 2], [1, -2], [1, 2]]
        for row in range(n):
            for col in range(n):
                number = grid[row][col]
                for direction in directions:
                    new_row = row + direction[0]
                    new_col = col + direction[1]
                    if new_row >= 0 and new_row < n and new_col >= 0 and new_col < n:
                        new_number = grid[new_row][new_col]
                        if abs(new_number - number) == 1:
                            return False
        return True