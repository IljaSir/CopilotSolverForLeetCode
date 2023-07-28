class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        
        piles = sorted(piles)[::-1]
        return sum(piles[1::3])