class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        dp = [0] + [float('inf')] * len(books)
        for i in range(len(books)):
            width, height = books[i]
            dp[i+1] = dp[i] + height
            for j in range(i-1, -1, -1):
                width += books[j][0]
                if width > shelfWidth:
                    break
                height = max(height, books[j][1])
                dp[i+1] = min(dp[i+1], dp[j] + height)
        return dp[-1]