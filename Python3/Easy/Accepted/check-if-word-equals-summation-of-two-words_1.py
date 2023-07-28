class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        
        
        def get_num(word):
            return int(''.join([str(ord(c) - ord('a')) for c in word]))
        
        return get_num(firstWord) + get_num(secondWord) == get_num(targetWord)