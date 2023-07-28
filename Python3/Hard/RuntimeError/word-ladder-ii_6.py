class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        # BFS + DFS
        # BFS to find the shortest path
        # DFS to find all the shortest paths
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        wordList.discard(beginWord)
        wordList.discard(endWord)
        head = {beginWord}
        tail = {endWord}
        dic = {beginWord: [[beginWord]]}
        neighbors = collections.defaultdict(set)
        while head and tail:
            if len(head) > len(tail):
                head, tail = tail, head
            wordList -= head
            newHead = set()
            for word in head:
                for i in range(len(word)):
                    for c in string.ascii_lowercase:
                        newWord = word[:i] + c + word[i+1:]
                        if newWord in tail:
                            if word not in dic:
                                dic[word] = []
                            dic[word].append(path + [newWord] for path in dic[newWord])
                            neighbors[word].add(newWord)
                            neighbors[newWord].add(word)
                        if newWord in wordList:
                            newHead.add(newWord)
                            if word not in dic:
                                dic[word] = []
                            dic[word].append([word, newWord])
                            neighbors[word].add(newWord)
                            neighbors[newWord].add(word)
            head = newHead
        if not neighbors:
            return []
        res = []
        def dfs(word, path):
            if word == endWord:
                res.append(path)
                return
            for neighbor in neighbors[word]:
                for p in dic[word]:
                    if neighbor == p[-1]:
                        dfs(neighbor, path + p)
        dfs(beginWord, [])
        return res