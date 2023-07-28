class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        words = sorted(words, key=len, reverse=True)
        max_product = 0
        for i, word1 in enumerate(words):
            if len(word1) ** 2 <= max_product:
                break
            for word2 in words[i+1:]:
                if not set(word1).intersection(set(word2)):
                    max_product = max(max_product, len(word1) * len(word2))
                    break
        return max_product