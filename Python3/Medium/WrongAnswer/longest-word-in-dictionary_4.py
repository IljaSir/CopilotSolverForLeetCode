class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        words = set(words)
        res = ""
        for w in words:
            if len(w) == 1 or w[:-1] in words:
                if len(w) > len(res):
                    res = w
        return res