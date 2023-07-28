class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        wordList.add(beginWord)
        wordList.add(endWord)
        visited = set()
        queue = deque()
        queue.append([beginWord])
        found = False
        result = []
        while queue:
            path = queue.popleft()
            word = path[-1]
            if word == endWord:
                result.append(path)
                found = True
            if found:
                continue
            for i in range(len(word)):
                for c in string.ascii_lowercase:
                    new_word = word[:i] + c + word[i+1:]
                    if new_word in wordList and new_word not in visited:
                        queue.append(path + [new_word])
            visited.add(word)
        return result