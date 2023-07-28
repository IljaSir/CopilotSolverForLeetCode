class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        for c in word:
            if c.isalpha():
                word = word.replace(c, ' ')
        return len(set([int(s) for s in word.split()]))