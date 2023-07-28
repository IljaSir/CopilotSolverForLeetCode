class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        words_set = set()
        res = ""
        for word in words:
            if len(word) == 1 or word[:-1] in words_set:
                words_set.add(word)
                if len(word) > len(res):
                    res = word
        return res