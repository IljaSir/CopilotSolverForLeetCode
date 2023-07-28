class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        seen = set()
        res = ""
        for word in words:
            if len(word) == 1 or word[:-1] in seen:
                seen.add(word)
                if len(word) > len(res):
                    res = word
        return res