class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        dp = [0]
        for i in range(len(books)):
            dp.append(dp[-1] + books[i][1])
            j = i - 1
            width = 0
            while j >= 0 and width + books[j][0] <= shelfWidth:
                width += books[j][0]
                dp[-1] = min(dp[-1], dp[j] + books[i][1])
                j -= 1
        return dp[-1]