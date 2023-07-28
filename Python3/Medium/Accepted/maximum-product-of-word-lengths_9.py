class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        # sort the list by length
        words.sort(key=len)
        # create a list of bitmasks
        masks = [0] * len(words)
        for i, word in enumerate(words):
            for char in word:
                masks[i] |= 1 << (ord(char) - ord('a'))
        # compare each word with the next ones
        max_product = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if masks[i] & masks[j] == 0:
                    max_product = max(max_product, len(words[i]) * len(words[j]))
        return max_product