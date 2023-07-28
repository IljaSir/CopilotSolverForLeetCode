class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        # dp[i] = min(dp[i], dp[j] + max(height[j+1..i]))
        n = len(books)
        dp = [0] + [float('inf')] * n
        for i in range(n):
            width, height = 0, 0
            for j in range(i, -1, -1):
                width += books[j][0]
                if width > shelfWidth: break
                height = max(height, books[j][1])
                dp[i+1] = min(dp[i+1], dp[j] + height)
        return dp[-1]