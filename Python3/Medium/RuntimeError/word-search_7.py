class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        if not board:
            return False
        if not word:
            return True
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word):
                    return True
        return False