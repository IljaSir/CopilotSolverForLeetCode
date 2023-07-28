class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words = sorted(words)
        words = set(words)
        longest = ''
        for word in words:
            if all(word[:i] in words for i in range(1, len(word))):
                if len(word) > len(longest):
                    longest = word
        return longest