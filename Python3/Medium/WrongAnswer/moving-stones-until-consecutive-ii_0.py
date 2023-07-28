class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        
        stones.sort()
        n = len(stones)
        min_moves = float('inf')
        max_moves = stones[-1] - stones[0] + 1 - n
        for i in range(n):
            j = i
            while j < n and stones[j] - stones[i] + 1 <= n:
                j += 1
            if j - i == n - 1 and stones[j - 1] - stones[i] + 1 == n - 1:
                min_moves = min(min_moves, 2)
            else:
                min_moves = min(min_moves, n - (j - i))
        return [min_moves, max_moves]