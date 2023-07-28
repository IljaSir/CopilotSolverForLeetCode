class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        def check_row(row):
            row = [x for x in row if x != '.']
            return len(row) == len(set(row))
        def check_col(col):
            col = [x for x in col if x != '.']
            return len(col) == len(set(col))
        def check_square(square):
            square = [x for x in square if x != '.']
            return len(square) == len(set(square))
        for row in board:
            if not check_row(row):
                return False
        for i in range(9):
            col = [row[i] for row in board]
            if not check_col(col):
                return False
        for i in range(3):
            for j in range(3):
                square = [board[3*i+x][3*j+y] for x in range(3) for y in range(3)]
                if not check_square(square):
                    return False
        return True