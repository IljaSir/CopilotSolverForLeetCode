class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        n = len(words)
        words = sorted(words, key = lambda x: len(x), reverse=True)
        words = [set(word) for word in words]
        ans = 0
        for i in range(n):
            for j in range(i):
                if not words[i] & words[j]:
                    ans = max(ans, len(words[i]) * len(words[j]))
                    break
        return ans