class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        
        m, n = len(board), len(board[0])
        visited = set()
        def dfs(x, y):
            if (x, y) in visited:
                return
            visited.add((x, y))
            if board[x][y] == "M":
                board[x][y] = "X"
                return
            cnt = 0
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == "M":
                    cnt += 1
            if cnt:
                board[x][y] = str(cnt)
            else:
                board[x][y] = "B"
                for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and board[nx][ny] == "E":
                        dfs(nx, ny)
        dfs(click[0], click[1])
        return board