class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        def validRow(board, row):
            seen = set()
            for i in range(9):
                if board[row][i] != '.':
                    if board[row][i] in seen:
                        return False
                    seen.add(board[row][i])
            return True
        
        def validCol(board, col):
            seen = set()
            for i in range(9):
                if board[i][col] != '.':
                    if board[i][col] in seen:
                        return False
                    seen.add(board[i][col])
            return True
        
        def validBox(board, row, col):
            seen = set()
            for i in range(row, row+3):
                for j in range(col, col+3):
                    if board[i][j] != '.':
                        if board[i][j] in seen:
                            return False
                        seen.add(board[i][j])
            return True
        
        for i in range(9):
            if not validRow(board, i) or not validCol(board, i):
                return False
        
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not validBox(board, i, j):
                    return False
        
        return True