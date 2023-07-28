class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def is_palindrome(word):
            return word == word[::-1]
        
        res = []
        for i, word1 in enumerate(words):
            for j, word2 in enumerate(words[i+1:]):
                if is_palindrome(word1 + word2):
                    res.append([i, i+j+1])
                if is_palindrome(word2 + word1):
                    res.append([i+j+1, i])
        return res