class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        
        def isConcatenated(word, wordset):
            if word in wordset:
                return True
            for i in range(1, len(word)):
                if word[:i] in wordset and isConcatenated(word[i:], wordset):
                    return True
            return False
        
        wordset = set(words)
        res = []
        for word in words:
            wordset.remove(word)
            if isConcatenated(word, wordset):
                res.append(word)
            wordset.add(word)
        return res