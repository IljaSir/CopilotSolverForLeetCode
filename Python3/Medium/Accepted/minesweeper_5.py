class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def dfs(board, i, j):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != 'E':
                return
            cnt = 0
            for x, y in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                if 0 <= i + x < len(board) and 0 <= j + y < len(board[0]) and board[i + x][j + y] == 'M':
                    cnt += 1
            if cnt == 0:
                board[i][j] = 'B'
                for x, y in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                    dfs(board, i + x, j + y)
            else:
                board[i][j] = str(cnt)
        if board[click[0]][click[1]] == 'M':
            board[click[0]][click[1]] = 'X'
        else:
            dfs(board, click[0], click[1])
        return board