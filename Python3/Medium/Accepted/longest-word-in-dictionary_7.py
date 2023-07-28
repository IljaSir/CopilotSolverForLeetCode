class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words = sorted(words)
        ans = ""
        word_set = set()
        for word in words:
            if len(word) == 1 or word[:-1] in word_set:
                ans = word if len(word) > len(ans) else ans
                word_set.add(word)
        return ans