class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        wordset = set()
        res = ""
        for word in words:
            if len(word) == 1 or word[:-1] in wordset:
                res = word if len(word) > len(res) else res
                wordset.add(word)
        return res