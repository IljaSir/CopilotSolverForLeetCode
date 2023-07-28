class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        
        word1 = list(word1)
        word2 = list(word2)
        word1.sort()
        word2.sort()
        word1 = ''.join(word1)
        word2 = ''.join(word2)
        if len(word1) != len(word2):
            return False
        if word1 == word2:
            return True
        if len(set(word1)) == len(set(word2)):
            return True
        return False