class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        
        dp = [0]
        for i in range(1, len(books) + 1):
            max_height = books[i-1][1]
            width = shelfWidth - books[i-1][0]
            dp.append(dp[i-1] + max_height)
            for j in range(i-1, 0, -1):
                if width >= books[j-1][0]:
                    max_height = max(max_height, books[j-1][1])
                    width -= books[j-1][0]
                    dp[i] = min(dp[i], dp[j-1] + max_height)
                else:
                    break
        return dp[-1]