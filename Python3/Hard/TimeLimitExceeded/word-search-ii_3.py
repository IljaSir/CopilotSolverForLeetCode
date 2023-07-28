class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        # Build a trie from words
        trie = {}
        for word in words:
            node = trie
            for char in word:
                if char not in node:
                    node[char] = {}
                node = node[char]
            node['#'] = word

        # Search for words in board
        def dfs(i, j, node, pre, visited):
            if '#' in node:
                res.add(node['#'])
            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n and (ni, nj) not in visited and board[ni][nj] in node:
                    visited.add((ni, nj))
                    dfs(ni, nj, node[board[ni][nj]], pre + board[ni][nj], visited)
                    visited.remove((ni, nj))

        res = set()
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    dfs(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return list(res)