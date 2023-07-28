class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def check(i, j, k):
            for x in range(9):
                if board[i][x] == k or board[x][j] == k or board[i // 3 * 3 + x // 3][j // 3 * 3 + x % 3] == k:
                    return False
            return True

        def solve():
            for i in range(9):
                for j in range(9):
                    if board[i][j] == '.':
                        for k in range(1, 10):
                            if check(i, j, str(k)):
                                board[i][j] = str(k)
                                if solve():
                                    return True
                                board[i][j] = '.'
                        return False
            return True

        solve()