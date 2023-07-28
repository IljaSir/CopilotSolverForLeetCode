class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        words = set(words)
        res = ''
        for w in words:
            if all(w[:i] in words for i in range(1, len(w))):
                if len(w) > len(res):
                    res = w
        return res