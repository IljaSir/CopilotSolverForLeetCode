class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        if not board or not word:
            return False
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0] and self.dfs(board, i, j, word, 0):
                    return True
        return False