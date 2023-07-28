class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        N = len(books)
        dp = [0] * (N+1)
        for i in range(1, N+1):
            dp[i] = dp[i-1] + books[i-1][1]
            j = i-1
            width = books[i-1][0]
            while j>0 and width + books[j-1][0] <= shelfWidth:
                width += books[j-1][0]
                j -= 1
                dp[i] = min(dp[i], dp[j] + max([book[1] for book in books[j:i]]))
        return dp[-1]