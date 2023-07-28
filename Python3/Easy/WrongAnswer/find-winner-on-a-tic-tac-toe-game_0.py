class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        
        
        def check_win(board):
            for i in range(3):
                if board[i][0] == board[i][1] == board[i][2] != ' ':
                    return board[i][0]
                if board[0][i] == board[1][i] == board[2][i] != ' ':
                    return board[0][i]
            if board[0][0] == board[1][1] == board[2][2] != ' ':
                return board[0][0]
            if board[0][2] == board[1][1] == board[2][0] != ' ':
                return board[0][2]
            return None
        
        board = [[' ' for _ in range(3)] for _ in range(3)]
        for i, move in enumerate(moves):
            if i % 2 == 0:
                board[move[0]][move[1]] = 'X'
            else:
                board[move[0]][move[1]] = 'O'
            if i >= 4:
                winner = check_win(board)
                if winner:
                    return winner
        return 'Draw' if len(moves) == 9 else 'Pending'