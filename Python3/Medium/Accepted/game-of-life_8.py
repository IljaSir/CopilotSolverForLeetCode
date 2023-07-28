class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def check_live(i, j):
            count = 0
            for x in range(i-1, i+2):
                for y in range(j-1, j+2):
                    if x == i and y == j:
                        continue
                    if 0 <= x < len(board) and 0 <= y < len(board[0]):
                        if board[x][y] == 1 or board[x][y] == -1:
                            count += 1
            return count
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = check_live(i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = -1
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == -1:
                    board[i][j] = 0