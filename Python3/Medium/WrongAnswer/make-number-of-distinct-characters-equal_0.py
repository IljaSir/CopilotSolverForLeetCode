class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        
        if len(word1) != len(word2):
            return False
        if set(word1) == set(word2):
            return True
        if len(set(word1)) == 26 and len(set(word2)) == 26:
            return False
        return True