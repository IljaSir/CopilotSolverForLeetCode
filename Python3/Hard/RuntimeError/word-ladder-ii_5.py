class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        self.wordSet = set(wordList)
        self.res = []
        self.minLen = float('inf')
        self.findLaddersHelper(beginWord, endWord, [beginWord])
        return self.res