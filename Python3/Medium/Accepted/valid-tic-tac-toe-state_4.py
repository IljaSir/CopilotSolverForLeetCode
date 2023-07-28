class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        
        def check_win(board, player):
            for i in range(3):
                if board[i][0] == board[i][1] == board[i][2] == player:
                    return True
            for i in range(3):
                if board[0][i] == board[1][i] == board[2][i] == player:
                    return True
            if board[0][0] == board[1][1] == board[2][2] == player:
                return True
            if board[0][2] == board[1][1] == board[2][0] == player:
                return True
            return False
        def check_draw(board):
            for i in range(3):
                for j in range(3):
                    if board[i][j] == ' ':
                        return False
            return True
        def check_valid(board):
            x_count = 0
            o_count = 0
            for i in range(3):
                for j in range(3):
                    if board[i][j] == 'X':
                        x_count += 1
                    elif board[i][j] == 'O':
                        o_count += 1
            if x_count < o_count or x_count > o_count + 1:
                return False
            if check_win(board, 'X') and x_count == o_count:
                return False
            if check_win(board, 'O') and x_count > o_count:
                return False
            if check_win(board, 'X') and check_win(board, 'O'):
                return False
            if check_draw(board) and x_count != o_count + 1:
                return False
            return True
        return check_valid(board)