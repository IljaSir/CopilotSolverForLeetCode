class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        # Get the number of rows and columns
        rows = len(board)
        cols = len(board[0])
        
        # Iterate through the board
        for i in range(rows):
            for j in range(cols):
                # Get the number of live neighbors
                live_neighbors = 0
                for x in range(i-1, i+2):
                    for y in range(j-1, j+2):
                        if (x >= 0 and x < rows and y >= 0 and y < cols and (x != i or y != j) and abs(board[x][y]) == 1):
                            live_neighbors += 1
                
                # Rule 1 or 3
                if (board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3)):
                    # -1 represents the cell is now dead but originally was live.
                    board[i][j] = -1
                # Rule 4
                if (board[i][j] == 0 and live_neighbors == 3):
                    # 2 represents the cell is now live but was originally dead.
                    board[i][j] = 2
        
        # Get the final representation for the newly updated board.
        for i in range(rows):
            for j in range(cols):
                if (board[i][j] > 0):
                    board[i][j] = 1
                else:
                    board[i][j] = 0