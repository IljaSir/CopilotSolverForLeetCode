class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        
        x, y = 0, 0
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == "R":
                    x, y = i, j
                    break
        res = 0
        for i in range(x, -1, -1):
            if board[i][y] == "B":
                break
            elif board[i][y] == "p":
                res += 1
                break
        for i in range(x, len(board)):
            if board[i][y] == "B":
                break
            elif board[i][y] == "p":
                res += 1
                break
        for i in range(y, -1, -1):
            if board[x][i] == "B":
                break
            elif board[x][i] == "p":
                res += 1
                break
        for i in range(y, len(board[0])):
            if board[x][i] == "B":
                break
            elif board[x][i] == "p":
                res += 1
                break
        return res