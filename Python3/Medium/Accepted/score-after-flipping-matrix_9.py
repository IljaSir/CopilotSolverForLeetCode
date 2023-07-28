class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        # Flip the first column to maximize the first bit
        for row in grid:
            if row[0] == 0:
                for i in range(len(row)):
                    row[i] = 1 - row[i]
        
        # Flip the rest of the columns to maximize the rest of the bits
        for col in range(1, len(grid[0])):
            zero_count = 0
            for row in grid:
                if row[col] == 0:
                    zero_count += 1
            if zero_count > len(grid) // 2:
                for row in grid:
                    row[col] = 1 - row[col]
        
        # Calculate the score
        score = 0
        for row in grid:
            score += int("".join([str(bit) for bit in row]), 2)
        return score