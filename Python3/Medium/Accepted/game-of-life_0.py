class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                lives = 0
                for x in range(max(i-1, 0), min(i+2, m)):
                    for y in range(max(j-1, 0), min(j+2, n)):
                        lives += board[x][y] & 1
                if lives == 3 or lives - board[i][j] == 3:
                    board[i][j] |= 2
        for i in range(m):
            for j in range(n):
                board[i][j] >>= 1