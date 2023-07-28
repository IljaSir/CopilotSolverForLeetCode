class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        if not words:
            return []
        word_len = len(words[0])
        words_len = len(words) * word_len
        res = []
        for i in range(len(s) - words_len + 1):
            if self.isConcat(s[i:i+words_len], words, word_len):
                res.append(i)
        return res