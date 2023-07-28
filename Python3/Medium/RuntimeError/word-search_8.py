class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        n = len(board)
        m = len(board[0])
        for i in range(n):
            for j in range(m):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False