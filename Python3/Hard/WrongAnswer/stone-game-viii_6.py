class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        
        for i in range(1, len(stones)):
            stones[i] += stones[i - 1]
        return max(stones[i] - stones[i - 1] for i in range(1, len(stones)))