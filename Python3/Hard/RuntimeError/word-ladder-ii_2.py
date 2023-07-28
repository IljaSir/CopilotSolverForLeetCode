class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        queue = collections.deque()
        queue.append([beginWord])
        res = []
        visited = set()
        while queue:
            size = len(queue)
            visited.clear()
            for _ in range(size):
                path = queue.popleft()
                if path[-1] == endWord:
                    res.append(path)
                else:
                    for word in self.get_next_words(path[-1], wordList):
                        if word not in visited:
                            queue.append(path + [word])
                            visited.add(word)
            if res:
                break
            wordList -= visited
        return res