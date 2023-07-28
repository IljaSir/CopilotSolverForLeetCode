class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        n = len(board)
        m = len(board[0])
        def neighbors(x, y):
            for i in range(x - 1, x + 2):
                for j in range(y - 1, y + 2):
                    if 0 <= i < n and 0 <= j < m and (i != x or j != y):
                        yield i, j
        for i in range(n):
            for j in range(m):
                count = 0
                for x, y in neighbors(i, j):
                    if board[x][y] & 1:
                        count += 1
                if board[i][j] & 1:
                    if count < 2 or count > 3:
                        board[i][j] = 1
                    else:
                        board[i][j] = 3
                else:
                    if count == 3:
                        board[i][j] = 2
        for i in range(n):
            for j in range(m):
                board[i][j] >>= 1