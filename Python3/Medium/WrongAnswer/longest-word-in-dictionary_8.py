class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        words_set = set(words)
        length = 0
        ans = ''
        for word in words:
            if len(word) == 1 or word[:-1] in words_set:
                if len(word) > length:
                    ans = word
                    length = len(word)
        return ans