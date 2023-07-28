class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        

        def canPlace(board, row, col, num):
            for i in range(9):
                if board[row][i] == num:
                    return False
                if board[i][col] == num:
                    return False
                if board[(row//3)*3 + i//3][(col//3)*3 + i%3] == num:
                    return False
            return True

        def solve(board):
            for i in range(9):
                for j in range(9):
                    if board[i][j] == '.':
                        for num in range(1, 10):
                            if canPlace(board, i, j, str(num)):
                                board[i][j] = str(num)
                                if solve(board):
                                    return True
                                board[i][j] = '.'
                        return False
            return True

        solve(board)