class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        bitmasks = []
        for word in words:
            bitmask = 0
            for letter in word:
                bitmask |= 1 << (ord(letter) - ord('a'))
            bitmasks.append(bitmask)
        ans = 0
        for i, bitmask1 in enumerate(bitmasks):
            for bitmask2 in bitmasks[i + 1:]:
                if bitmask1 & bitmask2 == 0:
                    ans = max(ans, len(words[i]) * len(words[bitmasks.index(bitmask2)]))
        return ans