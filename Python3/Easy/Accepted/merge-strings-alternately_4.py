class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        return ''.join(''.join(x) for x in zip_longest(word1, word2, fillvalue=''))