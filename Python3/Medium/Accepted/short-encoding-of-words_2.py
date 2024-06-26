class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        
        words.sort(key=len, reverse=True)
        s = set(words)
        for w in words:
            for i in range(1, len(w)):
                s.discard(w[i:])
        return sum(len(w) + 1 for w in s)