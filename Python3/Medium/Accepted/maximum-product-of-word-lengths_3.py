class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        def get_mask(word):
            mask = 0
            for c in word:
                mask |= 1 << (ord(c) - ord('a'))
            return mask
        words.sort(key=len)
        masks = [get_mask(word) for word in words]
        n = len(words)
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if masks[i] & masks[j] == 0:
                    ans = max(ans, len(words[i]) * len(words[j]))
        return ans