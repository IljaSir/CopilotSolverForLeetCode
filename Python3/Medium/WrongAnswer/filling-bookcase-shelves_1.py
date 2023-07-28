class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        dp = [0] + [float('inf')] * len(books)
        for i in range(len(books)):
            width, height = books[i]
            dp[i+1] = dp[i] + height
            j = i
            while width <= shelfWidth and j > 0:
                j -= 1
                width += books[j][0]
                height = max(height, books[j][1])
                dp[i+1] = min(dp[i+1], dp[j] + height)
        return dp[-1]