class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        

        def isValid(board, row, col, num):
            for i in range(9):
                if board[row][i] == num:
                    return False
                if board[i][col] == num:
                    return False
                if board[row//3*3 + i//3][col//3*3 + i%3] == num:
                    return False
            return True

        def solve(board):
            for row in range(9):
                for col in range(9):
                    if board[row][col] == '.':
                        for num in range(1, 10):
                            if isValid(board, row, col, str(num)):
                                board[row][col] = str(num)
                                if solve(board):
                                    return True
                                else:
                                    board[row][col] = '.'
                        return False
            return True

        solve(board)