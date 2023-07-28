class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        def isValid(board):
            for i in range(9):
                row = set()
                col = set()
                for j in range(9):
                    if board[i][j] != '.':
                        if board[i][j] in row:
                            return False
                        else:
                            row.add(board[i][j])
                    if board[j][i] != '.':
                        if board[j][i] in col:
                            return False
                        else:
                            col.add(board[j][i])
            return True
        def isValidSubBox(board):
            for i in range(3):
                for j in range(3):
                    subBox = set()
                    for m in range(3):
                        for n in range(3):
                            if board[i*3+m][j*3+n] != '.':
                                if board[i*3+m][j*3+n] in subBox:
                                    return False
                                else:
                                    subBox.add(board[i*3+m][j*3+n])
            return True
        return isValid(board) and isValidSubBox(board)