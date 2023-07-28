class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        trie = {}
        for word in words:
            node = trie
            for ch in word:
                node = node.setdefault(ch, {})
            node['#'] = word
        m, n = len(board), len(board[0])
        ans = []
        def dfs(i, j, node):
            ch = board[i][j]
            if ch not in node:
                return
            node = node[ch]
            if '#' in node:
                ans.append(node.pop('#'))
            board[i][j] = '@'
            if i > 0:
                dfs(i-1, j, node)
            if i < m-1:
                dfs(i+1, j, node)
            if j > 0:
                dfs(i, j-1, node)
            if j < n-1:
                dfs(i, j+1, node)
            board[i][j] = ch
        for i in range(m):
            for j in range(n):
                dfs(i, j, trie)
        return ans