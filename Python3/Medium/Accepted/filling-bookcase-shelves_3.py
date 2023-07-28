class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        n = len(books)
        dp = [0] * (n + 1)
        for i in range(n):
            dp[i+1] = dp[i] + books[i][1]
            w = books[i][0]
            h = books[i][1]
            j = i - 1
            while j >= 0 and w + books[j][0] <= shelfWidth:
                w += books[j][0]
                h = max(h, books[j][1])
                dp[i+1] = min(dp[i+1], dp[j] + h)
                j -= 1
        return dp[-1]