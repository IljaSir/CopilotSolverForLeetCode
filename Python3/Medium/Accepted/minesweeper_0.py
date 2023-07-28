class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        m, n = len(board), len(board[0])
        def dfs(i, j):
            if 0 <= i < m and 0 <= j < n:
                if board[i][j] == 'M':
                    board[i][j] = 'X'
                elif board[i][j] == 'E':
                    cnt = 0
                    for x, y in [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]:
                        if 0 <= x < m and 0 <= y < n and board[x][y] == 'M':
                            cnt += 1
                    if cnt == 0:
                        board[i][j] = 'B'
                        for x, y in [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]:
                            dfs(x, y)
                    else:
                        board[i][j] = str(cnt)
        dfs(*click)
        return board