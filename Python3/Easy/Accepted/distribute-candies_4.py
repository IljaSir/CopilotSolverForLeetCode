class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        
        n = len(candyType)
        candyType = set(candyType)
        return min(n // 2, len(candyType))