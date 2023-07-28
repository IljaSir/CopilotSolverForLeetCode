class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        def is_palindrome(word):
            return word == word[::-1]
        word_index = {w: i for i, w in enumerate(words)}
        pairs = []
        for i, word in enumerate(words):
            for j in range(len(word) + 1):
                prefix, suffix = word[:j], word[j:]
                if is_palindrome(prefix):
                    rev_suffix = suffix[::-1]
                    if rev_suffix in word_index and word_index[rev_suffix] != i:
                        pairs.append([word_index[rev_suffix], i])
                if suffix and is_palindrome(suffix):
                    rev_prefix = prefix[::-1]
                    if rev_prefix in word_index and word_index[rev_prefix] != i:
                        pairs.append([i, word_index[rev_prefix]])
        return pairs