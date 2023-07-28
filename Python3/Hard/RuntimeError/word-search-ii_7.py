class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        def dfs(i, j, node, pre):
            c = board[i][j]
            if c not in node:
                return
            node = node[c]
            if node['#'] == 1:
                res.append(pre+c)
                node['#'] = 0
            board[i][j] = '#'
            for x, y in ((i+1,j),(i-1,j),(i,j+1),(i,j-1)):
                if 0 <= x < m and 0 <= y < n and board[x][y] != '#':
                    dfs(x, y, node, pre+c)
            board[i][j] = c
        trie = {}
        for word in words:
            node = trie
            for c in word:
                node = node.setdefault(c, {})
            node['#'] = 1
        m, n = len(board), len(board[0])
        res = []
        for i in range(m):
            for j in range(n):
                dfs(i, j, trie, '')
        return res