class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        words = set(words)
        def isConcatenated(word):
            if word in words:
                return True
            for i in range(1, len(word)):
                if word[:i] in words and isConcatenated(word[i:]):
                    return True
            return False
        return [w for w in words if isConcatenated(w)]