class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # check rows
        for row in board:
            if not self.is_valid(row):
                return False
        # check cols
        for i in range(9):
            col = []
            for j in range(9):
                col.append(board[j][i])
            if not self.is_valid(col):
                return False
        # check 3x3
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                box = []
                for k in range(i, i+3):
                    for l in range(j, j+3):
                        box.append(board[k][l])
                if not self.is_valid(box):
                    return False
        return True