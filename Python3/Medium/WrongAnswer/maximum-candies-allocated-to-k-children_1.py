class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        
        n = len(candies)
        candies.sort()
        ans = 0
        for i in range(n-1, n-1-k, -1):
            ans += candies[i]
        return ans