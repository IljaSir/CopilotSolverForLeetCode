class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # check rows
        for row in board:
            if not self.isValidRow(row):
                return False
        # check columns
        for i in range(9):
            col = [board[j][i] for j in range(9)]
            if not self.isValidRow(col):
                return False
        # check sub-boxes
        for i in range(3):
            for j in range(3):
                sub_box = [board[3*i+x][3*j+y] for x in range(3) for y in range(3)]
                if not self.isValidRow(sub_box):
                    return False
        return True