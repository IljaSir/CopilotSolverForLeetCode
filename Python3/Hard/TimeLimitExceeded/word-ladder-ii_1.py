class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        if endWord not in wordList:
            return []
        wordList = set(wordList)
        n = len(beginWord)
        graph = collections.defaultdict(list)
        for word in wordList:
            for i in range(n):
                graph[word[:i] + '*' + word[i+1:]].append(word)
        queue = collections.deque([(beginWord, [beginWord])])
        visited = set()
        ans = []
        while queue:
            if ans:
                return ans
            for _ in range(len(queue)):
                word, path = queue.popleft()
                if word == endWord:
                    ans.append(path)
                for i in range(n):
                    for neigh in graph[word[:i] + '*' + word[i+1:]]:
                        if neigh not in visited:
                            queue.append((neigh, path + [neigh]))
            visited.update([word for word, _ in queue])
        return ans