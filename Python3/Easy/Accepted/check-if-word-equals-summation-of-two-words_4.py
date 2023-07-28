class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        
        
        def word2num(word):
            num = ''
            for i in word:
                num += str(ord(i)-ord('a'))
            return int(num)
        
        return word2num(firstWord) + word2num(secondWord) == word2num(targetWord)