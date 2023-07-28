class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for row in board:
            if not self.isValidRow(row):
                return False
        for col in zip(*board):
            if not self.isValidRow(col):
                return False
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not self.isValidRow([board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]):
                    return False
        return True