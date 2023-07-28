class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        words.sort(key = lambda word: len(word), reverse = True)
        n = len(words)
        bitmasks = [0] * n
        for i in range(n):
            for c in words[i]:
                bitmasks[i] |= 1 << (ord(c) - ord('a'))
        
        ans = 0
        for i in range(n):
            if len(words[i]) ** 2 <= ans:
                break
            for j in range(i + 1, n):
                if bitmasks[i] & bitmasks[j] == 0:
                    ans = max(ans, len(words[i]) * len(words[j]))
        return ans