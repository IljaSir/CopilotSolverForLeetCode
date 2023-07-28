class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        
        stones.sort()
        n = len(stones)
        i = 0
        min_moves = n
        max_moves = stones[n-1] - stones[0] + 1 - n
        for j in range(n):
            while stones[j] - stones[i] + 1 > n:
                i += 1
            if j - i + 1 == n - 1 and stones[j] - stones[i] + 1 == n - 1:
                min_moves = min(min_moves, 2)
            else:
                min_moves = min(min_moves, n - (j - i + 1))
        return [min_moves, max_moves]