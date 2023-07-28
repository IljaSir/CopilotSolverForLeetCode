class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        
        x_count = 0
        o_count = 0
        for row in board:
            for c in row:
                if c == 'X':
                    x_count += 1
                elif c == 'O':
                    o_count += 1
        if x_count < o_count or x_count > o_count + 1:
            return False
        if self.check_win(board, 'X') and x_count == o_count:
            return False
        if self.check_win(board, 'O') and x_count > o_count:
            return False
        return True