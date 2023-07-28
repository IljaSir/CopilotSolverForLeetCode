class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        
        
        def get_num(word):
            num = 0
            for c in word:
                num = num * 10 + (ord(c) - ord('a'))
            return num
        return get_num(firstWord) + get_num(secondWord) == get_num(targetWord)