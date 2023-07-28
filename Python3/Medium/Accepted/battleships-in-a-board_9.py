class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        
        def is_valid(i, j):
            if i < 0 or i >= len(board):
                return False
            if j < 0 or j >= len(board[0]):
                return False
            return True
        count = 0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 'X':
                    if is_valid(i-1, j) and board[i-1][j] == 'X':
                        continue
                    if is_valid(i, j-1) and board[i][j-1] == 'X':
                        continue
                    count += 1
        return count