class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        
        def check_win(board, player):
            for i in range(3):
                if all(board[i][j] == player for j in range(3)):
                    return True
                if all(board[j][i] == player for j in range(3)):
                    return True
            if all(board[i][i] == player for i in range(3)):
                return True
            if all(board[i][2-i] == player for i in range(3)):
                return True
            return False
        x_count = sum(row.count('X') for row in board)
        o_count = sum(row.count('O') for row in board)
        if o_count not in [x_count, x_count - 1]:
            return False
        if check_win(board, 'X') and x_count != o_count + 1:
            return False
        if check_win(board, 'O') and x_count != o_count:
            return False
        return True