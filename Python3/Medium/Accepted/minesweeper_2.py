class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def dfs(i, j):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
                return
            if board[i][j] != 'E':
                return
            count = 0
            for x, y in [(1, 1), (1, -1), (-1, 1), (-1, -1), (1, 0), (-1, 0), (0, 1), (0, -1)]:
                if 0 <= i + x < len(board) and 0 <= j + y < len(board[0]) and board[i + x][j + y] == 'M':
                    count += 1
            if count == 0:
                board[i][j] = 'B'
                for x, y in [(1, 1), (1, -1), (-1, 1), (-1, -1), (1, 0), (-1, 0), (0, 1), (0, -1)]:
                    dfs(i + x, j + y)
            else:
                board[i][j] = str(count)
        if board[click[0]][click[1]] == 'M':
            board[click[0]][click[1]] = 'X'
            return board
        dfs(click[0], click[1])
        return board