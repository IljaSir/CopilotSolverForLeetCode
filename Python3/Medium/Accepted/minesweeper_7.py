class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def dfs(board, i, j):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != "E":
                return
            mines = 0
            for x, y in [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]:
                if 0 <= x < len(board) and 0 <= y < len(board[0]) and board[x][y] == "M":
                    mines += 1
            if mines > 0:
                board[i][j] = str(mines)
            else:
                board[i][j] = "B"
                for x, y in [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]:
                    dfs(board, x, y)
        
        i, j = click[0], click[1]
        if board[i][j] == "M":
            board[i][j] = "X"
        else:
            dfs(board, i, j)
        return board