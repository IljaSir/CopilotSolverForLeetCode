class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        def get_neighbors(i, j):
            for x in range(max(0, i - 1), min(i + 2, len(board))):
                for y in range(max(0, j - 1), min(j + 2, len(board[0]))):
                    yield x, y
        
        def get_live_neighbors(i, j):
            for x, y in get_neighbors(i, j):
                if x == i and y == j:
                    continue
                yield x, y
        
        def count_live_neighbors(i, j):
            count = 0
            for x, y in get_live_neighbors(i, j):
                count += board[x][y] & 1
            return count
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = count_live_neighbors(i, j)
                if board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 2
                else:
                    if count < 2 or count > 3:
                        board[i][j] = 1
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] >>= 1