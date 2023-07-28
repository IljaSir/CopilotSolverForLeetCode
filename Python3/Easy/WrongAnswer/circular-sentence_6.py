class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        
        words = sentence.split()
        return words[0][0] == words[-1][-1]