class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        def check_row(row):
            row = [x for x in row if x != '.']
            return len(row) == len(set(row))
        
        def check_col(col):
            col = [x for x in col if x != '.']
            return len(col) == len(set(col))
        
        def check_3x3(row, col):
            box = [board[i][j] for i in range(row, row+3) for j in range(col, col+3)]
            box = [x for x in box if x != '.']
            return len(box) == len(set(box))
        
        for i in range(9):
            if not check_row(board[i]):
                return False
            if not check_col([board[j][i] for j in range(9)]):
                return False
            if i % 3 == 0 and i != 0:
                row = i - 3
                col = 0
                while col < 9:
                    if not check_3x3(row, col):
                        return False
                    col += 3
        return True