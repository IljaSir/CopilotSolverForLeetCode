class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        
        return ' '.join([self.toGoatLatinWord(w, i+1) for i, w in enumerate(sentence.split(' '))])