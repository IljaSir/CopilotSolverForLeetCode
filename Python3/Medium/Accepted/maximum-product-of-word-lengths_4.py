class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        # Convert words to bitmasks
        bitmasks = []
        for word in words:
            bitmask = 0
            for letter in word:
                bitmask |= 1 << (ord(letter) - ord('a'))
            bitmasks.append(bitmask)
        
        # Find maximum product
        max_product = 0
        for i, bitmask1 in enumerate(bitmasks):
            for j, bitmask2 in enumerate(bitmasks):
                if not bitmask1 & bitmask2:
                    max_product = max(max_product, len(words[i]) * len(words[j]))
        return max_product