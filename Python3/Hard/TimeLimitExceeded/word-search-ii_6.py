class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        # 1. Build Trie
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = word
        
        # 2. DFS
        def dfs(i, j, node, pre, visited):
            if '#' in node:
                res.append(node['#'])
                node.pop('#')
            
            for x, y in ((i-1, j), (i+1, j), (i, j-1), (i, j+1)):
                if 0 <= x < m and 0 <= y < n and board[x][y] in node and (x, y) not in visited:
                    dfs(x, y, node[board[x][y]], pre+board[x][y], visited | {(x, y)})
        
        # 3. Search
        res = []
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    dfs(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return res