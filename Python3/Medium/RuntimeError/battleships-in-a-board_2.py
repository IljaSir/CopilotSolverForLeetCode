class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        
        m, n = len(board), len(board[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'X':
                    count += 1
                    self.dfs(board, i, j)
        return count