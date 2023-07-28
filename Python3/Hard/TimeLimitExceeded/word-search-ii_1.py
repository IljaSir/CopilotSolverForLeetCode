class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        m, n = len(board), len(board[0])
        def dfs(i, j, word):
            if not word:
                return True
            if i < 0 or i >= m or j < 0 or j >= n or board[i][j] != word[0]:
                return False
            board[i][j] = '#'
            res = dfs(i + 1, j, word[1:]) or dfs(i - 1, j, word[1:]) or dfs(i, j + 1, word[1:]) or dfs(i, j - 1, word[1:])
            board[i][j] = word[0]
            return res
        return [word for word in words if any(dfs(i, j, word) for i in range(m) for j in range(n))]