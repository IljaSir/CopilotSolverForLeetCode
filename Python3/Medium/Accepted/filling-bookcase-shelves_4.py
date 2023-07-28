class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        N = len(books)
        dp = [0] * (N+1)
        for i in range(N):
            width, height = books[i]
            dp[i+1] = dp[i] + height
            for j in range(i-1, -1, -1):
                width += books[j][0]
                if width > shelfWidth:
                    break
                height = max(height, books[j][1])
                dp[i+1] = min(dp[i+1], dp[j] + height)
        return dp[N]