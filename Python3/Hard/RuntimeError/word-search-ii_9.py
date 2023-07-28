class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        def dfs(i, j, root, word):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
                return
            if board[i][j] == '#':
                return
            ch = board[i][j]
            if ch not in root:
                return
            root = root[ch]
            word += ch
            if root['#']:
                res.add(word)
            board[i][j] = '#'
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                dfs(x, y, root, word)
            board[i][j] = ch

        res = set()
        root = {}
        for word in words:
            node = root
            for ch in word:
                node = node.setdefault(ch, {})
            node['#'] = True
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(i, j, root, '')
        return list(res)