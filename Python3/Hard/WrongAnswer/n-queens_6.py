class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def check(row, col):
            for i in range(row):
                if board[i] == col or abs(row - i) == abs(col - board[i]):
                    return False
            return True
        
        def dfs(row):
            if row == n:
                res.append([''.join('.'*i + 'Q' + '.'*(n-i-1) for i in board)])
                return
            for col in range(n):
                if check(row, col):
                    board[row] = col
                    dfs(row+1)
        
        board = [-1] * n
        res = []
        dfs(0)
        return res