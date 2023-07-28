class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        # build a trie
        trie = {}
        for i, word in enumerate(words):
            node = trie
            for j, c in enumerate(word):
                node = node.setdefault(c, {})
                if word[j+1:][::-1] in words:
                    node.setdefault('_palindrome', []).append(i)
            node.setdefault('_end', []).append(i)
        
        # search in the trie
        res = []
        for i, word in enumerate(words):
            node = trie
            for j, c in enumerate(word):
                if '_end' in node and word[j:][::-1] in words:
                    res.append([i, node['_end'][0]])
                if c not in node:
                    break
                node = node[c]
            else:
                if '_palindrome' in node:
                    for j in node['_palindrome']:
                        if i != j:
                            res.append([i, j])
        return res