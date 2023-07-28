class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        word = re.sub(r"\D", " ", word)
        word = word.split()
        word = set(word)
        return len(word)