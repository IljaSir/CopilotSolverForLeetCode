class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        words.sort()
        words = set(words)
        ans = ""
        for word in words:
            if len(word) > len(ans) or (len(word) == len(ans) and word < ans):
                if all(word[:k] in words for k in range(1, len(word))):
                    ans = word
        return ans