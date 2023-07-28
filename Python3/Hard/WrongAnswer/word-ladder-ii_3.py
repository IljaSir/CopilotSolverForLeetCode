class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        if endWord not in wordList:
            return []
        wordList = set(wordList)
        wordList.discard(beginWord)
        wordList.discard(endWord)
        res = []
        queue = [(beginWord, [beginWord])]
        while queue:
            new_queue = []
            visited = set()
            for word, path in queue:
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in wordList:
                            new_path = path + [new_word]
                            if new_word == endWord:
                                res.append(new_path)
                            else:
                                new_queue.append((new_word, new_path))
                                visited.add(new_word)
            if res:
                return res
            queue = new_queue
            wordList -= visited
        return []