class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        m, n = len(board), len(board[0])
        def dfs(x, y):
            if 0 <= x < m and 0 <= y < n:
                if board[x][y] == 'E':
                    count = sum([board[x+i][y+j] == 'M' for i in (-1,0,1) for j in (-1,0,1) if 0 <= x+i < m and 0 <= y+j < n])
                    if count > 0:
                        board[x][y] = str(count)
                    else:
                        board[x][y] = 'B'
                        for i in (-1,0,1):
                            for j in (-1,0,1):
                                dfs(x+i, y+j)
        dfs(*click)
        return board