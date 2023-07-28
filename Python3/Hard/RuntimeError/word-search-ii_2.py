class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        root = {}
        for word in words:
            node = root
            for letter in word:
                node = node.setdefault(letter, {})
            node['#'] = '#'
        self.res = set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] in root:
                    self.dfs(board, i, j, '', root)
        return list(self.res)