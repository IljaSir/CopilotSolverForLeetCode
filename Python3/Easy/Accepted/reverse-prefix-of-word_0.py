class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        
        if ch not in word:
            return word
        else:
            return word[:word.index(ch)+1][::-1] + word[word.index(ch)+1:]