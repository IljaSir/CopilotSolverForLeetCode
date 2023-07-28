class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        m = len(board)
        n = len(board[0])
        def dfs(r, c):
            if r < 0 or r >= m or c < 0 or c >= n:
                return
            if board[r][c] == 'M':
                board[r][c] = 'X'
                return
            if board[r][c] != 'E':
                return
            cnt = 0
            for i in range(r-1, r+2):
                for j in range(c-1, c+2):
                    if i < 0 or i >= m or j < 0 or j >= n:
                        continue
                    if board[i][j] == 'M':
                        cnt += 1
            if cnt == 0:
                board[r][c] = 'B'
                for i in range(r-1, r+2):
                    for j in range(c-1, c+2):
                        if i < 0 or i >= m or j < 0 or j >= n:
                            continue
                        dfs(i, j)
            else:
                board[r][c] = str(cnt)
        dfs(click[0], click[1])
        return board