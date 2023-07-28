class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        row = [set() for _ in range(9)]
        col = [set() for _ in range(9)]
        cell = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    c = board[i][j]
                    if c in row[i] or c in col[j] or c in cell[i // 3 * 3 + j // 3]:
                        return False
                    row[i].add(c)
                    col[j].add(c)
                    cell[i // 3 * 3 + j // 3].add(c)
        return True