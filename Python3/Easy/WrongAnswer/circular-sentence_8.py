class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        
        words = sentence.split(" ")
        return words[-1][0] == words[0][0]