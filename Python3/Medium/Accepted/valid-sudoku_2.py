class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(9):
            row = {}
            col = {}
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] in row:
                        return False
                    row[board[i][j]] = 1
                if board[j][i] != '.':
                    if board[j][i] in col:
                        return False
                    col[board[j][i]] = 1
        for i in range(3):
            for j in range(3):
                box = {}
                for m in range(3):
                    for n in range(3):
                        if board[i*3+m][j*3+n] != '.':
                            if board[i*3+m][j*3+n] in box:
                                return False
                            box[board[i*3+m][j*3+n]] = 1
        return True