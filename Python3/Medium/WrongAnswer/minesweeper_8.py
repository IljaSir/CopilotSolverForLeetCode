class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def dfs(i, j):
            if board[i][j] == "M":
                board[i][j] = "X"
                return
            elif board[i][j] == "E":
                board[i][j] = "B"
                for x, y in [(i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1)]:
                    if 0 <= x < len(board) and 0 <= y < len(board[0]):
                        if board[x][y] == "E":
                            dfs(x, y)
        i, j = click
        if board[i][j] == "M":
            board[i][j] = "X"
        else:
            dfs(i, j)
        return board