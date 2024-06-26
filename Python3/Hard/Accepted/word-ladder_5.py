class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        q = deque()
        q.append((beginWord, 1))
        while q:
            word, length = q.popleft()
            if word == endWord:
                return length
            for i in range(len(word)):
                for c in string.ascii_lowercase:
                    new_word = word[:i] + c + word[i + 1:]
                    if new_word in wordList:
                        wordList.remove(new_word)
                        q.append((new_word, length + 1))
        return 0