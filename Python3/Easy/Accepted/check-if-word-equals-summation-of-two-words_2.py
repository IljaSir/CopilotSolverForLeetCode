class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        
        
        def get_number(word):
            return int(''.join([str(ord(c) - ord('a')) for c in word]))
        
        return get_number(firstWord) + get_number(secondWord) == get_number(targetWord)