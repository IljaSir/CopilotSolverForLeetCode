class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def count(i, j):
            cnt = 0
            for x in range(i-1, i+2):
                for y in range(j-1, j+2):
                    if x == i and y == j:
                        continue
                    if x < 0 or y < 0 or x >= m or y >= n:
                        continue
                    if board[x][y] == 1 or board[x][y] == 2:
                        cnt += 1
            return cnt
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                cnt = count(i, j)
                if board[i][j] == 1:
                    if cnt < 2 or cnt > 3:
                        board[i][j] = 2
                else:
                    if cnt == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                elif board[i][j] == 2:
                    board[i][j] = 0