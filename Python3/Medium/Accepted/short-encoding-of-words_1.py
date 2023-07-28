class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        
        w = set(words)
        for word in words:
            for i in range(1, len(word)):
                w.discard(word[i:])
        return sum(len(word) + 1 for word in w)