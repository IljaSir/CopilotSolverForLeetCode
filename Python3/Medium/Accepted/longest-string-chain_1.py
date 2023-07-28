class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        
        words.sort(key=lambda x: len(x))
        dp = {}
        for w in words:
            dp[w] = 1
            for i in range(len(w)):
                tmp = w[:i] + w[i+1:]
                if tmp in dp:
                    dp[w] = max(dp[w], dp[tmp] + 1)
        return max(dp.values())