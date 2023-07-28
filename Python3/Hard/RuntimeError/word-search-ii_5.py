class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        self.board = board
        self.ans = set()
        self.root = {}
        for word in words:
            node = self.root
            for c in word:
                node = node.setdefault(c, {})
            node['#'] = True
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in self.root:
                    self.dfs(i, j, '', self.root)
        return list(self.ans)