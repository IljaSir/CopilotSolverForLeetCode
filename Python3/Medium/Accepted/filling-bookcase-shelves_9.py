class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        # dp[i] = min height of first i books
        # dp[i] = min(dp[j] + max(books[j+1].height, ..., books[i].height)) for all j < i
        # dp[0] = 0
        n = len(books)
        dp = [0] * (n+1)
        for i in range(1, n+1):
            dp[i] = dp[i-1] + books[i-1][1]
            j = i-1
            w = shelfWidth - books[i-1][0]
            while j > 0 and w >= books[j-1][0]:
                w -= books[j-1][0]
                dp[i] = min(dp[i], dp[j-1] + max(books[j-1:i], key=lambda x: x[1])[1])
                j -= 1
        return dp[n]