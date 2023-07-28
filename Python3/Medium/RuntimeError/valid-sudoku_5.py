class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if not self.is_valid(board, i, j):
                        return False
        return True