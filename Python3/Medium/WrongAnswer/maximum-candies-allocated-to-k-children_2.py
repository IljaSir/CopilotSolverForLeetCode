class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        
        candies.sort()
        n = len(candies)
        c = n // k
        d = n % k
        res = 0
        for i in range(c):
            res += sum(candies[i*k:(i+1)*k])
        res += sum(candies[c*k:c*k+d])
        return res