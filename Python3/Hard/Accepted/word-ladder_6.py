class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        beginSet = {beginWord}
        endSet = {endWord}
        wordLen = len(beginWord)
        step = 1
        while beginSet:
            step += 1
            nextLevel = set()
            for word in beginSet:
                for i in range(wordLen):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        newWord = word[:i] + c + word[i+1:]
                        if newWord in endSet:
                            return step
                        if newWord in wordList:
                            wordList.remove(newWord)
                            nextLevel.add(newWord)
            beginSet = nextLevel
            if len(beginSet) > len(endSet):
                beginSet, endSet = endSet, beginSet
        return 0