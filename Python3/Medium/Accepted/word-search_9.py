class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def find_word(board, word, i, j, k):
            if k == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[k]:
                return False
            board[i][j] = ''
            res = find_word(board, word, i + 1, j, k + 1) or find_word(board, word, i - 1, j, k + 1) or find_word(board, word, i, j + 1, k + 1) or find_word(board, word, i, j - 1, k + 1)
            board[i][j] = word[k]
            return res
        for i in range(len(board)):
            for j in range(len(board[0])):
                if find_word(board, word, i, j, 0):
                    return True
        return False