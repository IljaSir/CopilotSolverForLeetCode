class Solution:
    def maxProduct(self, words: List[str]) -> int:
        
        n = len(words)
        if n == 2:
            return len(words[0]) * len(words[1])
        words.sort(key=len, reverse=True)
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if set(words[i]) & set(words[j]) == set():
                    ans = max(ans, len(words[i]) * len(words[j]))
                    break
        return ans