class Solution:
    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        
        class Node:
            def __init__(self):
                self.children = {}
                self.is_end = False
        class Trie:
            def __init__(self):
                self.root = Node()
            def insert(self, path):
                node = self.root
                for p in path:
                    if p not in node.children:
                        node.children[p] = Node()
                    node = node.children[p]
                node.is_end = True
            def search(self, path):
                node = self.root
                for p in path:
                    if p not in node.children:
                        return False
                    node = node.children[p]
                return node.is_end
        def dfs(node, path):
            for p in sorted(node.children.keys()):
                path.append(p)
                if node.children[p].is_end:
                    res.append(path[:])
                dfs(node.children[p], path)
                path.pop()
        trie = Trie()
        for path in paths:
            trie.insert(path)
        res = []
        dfs(trie.root, [])
        return res