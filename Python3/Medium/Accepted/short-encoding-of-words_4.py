class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        
        words = list(set(words))
        words.sort(key=lambda x: len(x), reverse=True)
        res = 0
        for i, w in enumerate(words):
            if all(w != words[j][-len(w):] for j in range(i)):
                res += len(w) + 1
        return res