class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        # 从后往前
        front, back = {beginWord}, {endWord}
        visited = set()
        res = []
        found = False
        path = {}
        def construct_path(beginWord, endWord):
            if beginWord == endWord:
                return [[endWord]]
            return [[beginWord] + rest for word in path[beginWord] for rest in construct_path(word, endWord)]
        while front and not found:
            visited |= front
            next_front = set()
            for word in front:
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in back:
                            found = True
                            if new_word not in path:
                                path[new_word] = []
                            path[new_word].append(word)
                        if new_word not in visited and new_word in wordList:
                            next_front.add(new_word)
                            if new_word not in path:
                                path[new_word] = []
                            path[new_word].append(word)
            front = next_front
            if len(front) > len(back):
                front, back = back, front
        return construct_path(beginWord, endWord)