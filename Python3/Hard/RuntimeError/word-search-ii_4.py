class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        if not board or not board[0]:
            return []
        if not words:
            return []
        self.rows = len(board)
        self.cols = len(board[0])
        self.board = board
        self.result = set()
        self.root = {}
        for word in words:
            node = self.root
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = word
        for row in range(self.rows):
            for col in range(self.cols):
                if board[row][col] in self.root:
                    self.backtrack(row, col, '', self.root)
        return list(self.result)