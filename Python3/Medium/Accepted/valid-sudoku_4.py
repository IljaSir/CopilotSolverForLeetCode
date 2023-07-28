class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # rows
        for i in range(9):
            s = set()
            for j in range(9):
                if board[i][j] != '.':
                    if board[i][j] in s:
                        return False
                    s.add(board[i][j])
        # columns
        for j in range(9):
            s = set()
            for i in range(9):
                if board[i][j] != '.':
                    if board[i][j] in s:
                        return False
                    s.add(board[i][j])
        # sub-boxes
        for i in range(3):
            for j in range(3):
                s = set()
                for m in range(3):
                    for n in range(3):
                        if board[i*3+m][j*3+n] != '.':
                            if board[i*3+m][j*3+n] in s:
                                return False
                            s.add(board[i*3+m][j*3+n])
        return True