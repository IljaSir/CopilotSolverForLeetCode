class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def possible(y, x, n):
            for i in range(9):
                if board[y][i] == n:
                    return False
            for i in range(9):
                if board[i][x] == n:
                    return False
            x0 = (x//3)*3
            y0 = (y//3)*3
            for i in range(3):
                for j in range(3):
                    if board[y0+i][x0+j] == n:
                        return False
            return True
        
        def solve():
            for y in range(9):
                for x in range(9):
                    if board[y][x] == '.':
                        for n in range(1, 10):
                            if possible(y, x, str(n)):
                                board[y][x] = str(n)
                                solve()
                                board[y][x] = '.'
                        return
            nonlocal solved
            solved = True
        
        solved = False
        solve()