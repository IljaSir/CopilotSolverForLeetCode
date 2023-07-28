class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        self.words = words
        self.board = board
        self.m = len(board)
        self.n = len(board[0])
        self.res = set()
        self.trie = self.build_trie()
        for i in range(self.m):
            for j in range(self.n):
                self.dfs(i, j, '', self.trie)
        return list(self.res)