class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(9):
            row = set()
            col = set()
            cube = set()
            for j in range(9):
                if board[i][j] != '.' and board[i][j] in row:
                    return False
                row.add(board[i][j])
                if board[j][i] != '.' and board[j][i] in col:
                    return False
                col.add(board[j][i])
                cube_row = i // 3 * 3 + j // 3
                cube_col = i % 3 * 3 + j % 3
                if board[cube_row][cube_col] != '.' and board[cube_row][cube_col] in cube:
                    return False
                cube.add(board[cube_row][cube_col])
        return True