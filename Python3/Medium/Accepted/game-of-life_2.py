class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = 0
                for x in range(max(0, i - 1), min(m, i + 2)):
                    for y in range(max(0, j - 1), min(n, j + 2)):
                        if x == i and y == j:
                            continue
                        if board[x][y] == 1 or board[x][y] == 2:
                            count += 1
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1