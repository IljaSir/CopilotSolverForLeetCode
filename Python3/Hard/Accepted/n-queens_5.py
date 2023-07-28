class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def check(row, col):
            for i in range(row):
                if board[i][col] == 'Q':
                    return False
            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j -= 1
            i, j = row - 1, col + 1
            while i >= 0 and j < n:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j += 1
            return True
        
        def dfs(row):
            if row == n:
                res.append([''.join(row) for row in board])
                return
            for col in range(n):
                if not check(row, col):
                    continue
                board[row][col] = 'Q'
                dfs(row + 1)
                board[row][col] = '.'
        
        board = [['.' for _ in range(n)] for _ in range(n)]
        res = []
        dfs(0)
        return res