class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        

        def check_row(row, num):
            for i in range(9):
                if board[row][i] == num:
                    return False
            return True

        def check_col(col, num):
            for i in range(9):
                if board[i][col] == num:
                    return False
            return True

        def check_square(row, col, num):
            for i in range(3):
                for j in range(3):
                    if board[i+row][j+col] == num:
                        return False
            return True

        def is_valid(row, col, num):
            return check_row(row, num) and check_col(col, num) and check_square(row - row % 3, col - col % 3, num)

        def solve():
            for row in range(9):
                for col in range(9):
                    if board[row][col] == '.':
                        for num in range(1, 10):
                            num = str(num)
                            if is_valid(row, col, num):
                                board[row][col] = num
                                if solve():
                                    return True
                                else:
                                    board[row][col] = '.'
                        return False
            return True

        solve()