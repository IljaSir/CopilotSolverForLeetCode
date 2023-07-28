class Solution:
    def countValidWords(self, sentence: str) -> int:
        
        return len([word for word in sentence.split() if self.is_valid(word)])