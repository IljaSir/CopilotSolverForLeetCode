class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        
        sentence = sentence.split(' ')
        return all([sentence[i][-1].lower() == sentence[i+1][0].lower() for i in range(len(sentence)-1)]) and sentence[-1][-1].lower() == sentence[0][0].lower()