class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        def get_mask(word):
            mask = 0
            for c in word:
                mask |= 1 << (ord(c) - ord('a'))
            return mask
        words = sorted(words, key=lambda x: len(x), reverse=True)
        masks = [get_mask(word) for word in words]
        for i, word in enumerate(words):
            for j in range(i):
                if masks[i] & masks[j] == 0:
                    return len(word) * len(words[j])
        return 0