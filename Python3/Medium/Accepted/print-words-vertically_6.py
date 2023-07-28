class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split()
        max_word_length = len(max(words, key=len))
        words = [word.ljust(max_word_length) for word in words]
        return [''.join(word[i] for word in words).rstrip() for i in range(max_word_length)]