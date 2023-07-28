class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        
        n = len(candyType)
        return min(len(set(candyType)), n // 2)