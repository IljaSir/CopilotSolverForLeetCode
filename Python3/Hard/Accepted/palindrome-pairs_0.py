class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def is_palindrome(word):
            return word == word[::-1]
        words = {word: i for i, word in enumerate(words)}
        res = []
        for word, i in words.items():
            for j in range(len(word) + 1):
                prefix, suffix = word[:j], word[j:]
                if is_palindrome(prefix):
                    rev_suffix = suffix[::-1]
                    if rev_suffix in words and words[rev_suffix] != i:
                        res.append([words[rev_suffix], i])
                if j != len(word) and is_palindrome(suffix):
                    rev_prefix = prefix[::-1]
                    if rev_prefix in words and words[rev_prefix] != i:
                        res.append([i, words[rev_prefix]])
        return res