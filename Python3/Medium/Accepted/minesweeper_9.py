class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        def dfs(i, j):
            if board[i][j] == "M":
                board[i][j] = "X"
            else:
                cnt = 0
                for x in range(i-1, i+2):
                    for y in range(j-1, j+2):
                        if 0 <= x < m and 0 <= y < n and board[x][y] == "M":
                            cnt += 1
                if cnt > 0:
                    board[i][j] = str(cnt)
                else:
                    board[i][j] = "B"
                    for x in range(i-1, i+2):
                        for y in range(j-1, j+2):
                            if 0 <= x < m and 0 <= y < n and board[x][y] == "E":
                                dfs(x, y)
        m, n = len(board), len(board[0])
        dfs(click[0], click[1])
        return board