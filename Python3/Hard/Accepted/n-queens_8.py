class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        res = []
        def isvalid(board, row, col):
            for i in range(row):
                if board[i][col] == 'Q':
                    return False
            i, j = row-1, col-1
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j -= 1
            i, j = row-1, col+1
            while i >= 0 and j < n:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j += 1
            return True
        def dfs(board, row):
            if row == n:
                res.append([''.join(x) for x in board])
                return
            for col in range(n):
                if isvalid(board, row, col):
                    board[row][col] = 'Q'
                    dfs(board, row+1)
                    board[row][col] = '.'
        dfs([['.' for _ in range(n)] for _ in range(n)], 0)
        return res