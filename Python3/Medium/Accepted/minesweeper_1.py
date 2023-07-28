class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        m = len(board)
        n = len(board[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        def dfs(board, click):
            i, j = click
            if board[i][j] == 'M':
                board[i][j] = 'X'
                return
            cnt = 0
            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if ni < 0 or ni >= m or nj < 0 or nj >= n:
                    continue
                if board[ni][nj] == 'M' or board[ni][nj] == 'X':
                    cnt += 1
            if cnt > 0:
                board[i][j] = str(cnt)
                return
            board[i][j] = 'B'
            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if ni < 0 or ni >= m or nj < 0 or nj >= n:
                    continue
                if board[ni][nj] == 'E':
                    dfs(board, [ni, nj])
        dfs(board, click)
        return board