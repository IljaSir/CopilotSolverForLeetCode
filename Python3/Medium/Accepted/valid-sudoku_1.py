class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(9):
            row = set()
            col = set()
            box = set()
            for j in range(9):
                if board[i][j] != '.' and board[i][j] in row:
                    return False
                row.add(board[i][j])
                if board[j][i] != '.' and board[j][i] in col:
                    return False
                col.add(board[j][i])
                r = (i//3)*3 + j//3
                c = (i%3)*3 + j%3
                if board[r][c] != '.' and board[r][c] in box:
                    return False
                box.add(board[r][c])
        return True