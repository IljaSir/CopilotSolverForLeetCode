class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        
        stones.sort()
        n = len(stones)
        min_moves = n
        max_moves = stones[-1] - stones[0] + 1 - n
        for i in range(n):
            for j in range(i+1, n):
                if stones[j] - stones[i] + 1 == j - i + 1:
                    min_moves = min(min_moves, n - (j - i + 1))
        return [min_moves, max_moves]