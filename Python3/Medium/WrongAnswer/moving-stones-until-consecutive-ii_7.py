class Solution:
    def numMovesStonesII(self, stones: List[int]) -> List[int]:
        
        stones.sort()
        n = len(stones)
        max_gap = max(stones[i+1]-stones[i]-1 for i in range(n-1))
        left, right = 0, 0
        min_gap = n
        for i in range(n):
            while stones[i] - stones[left] + 1 > n:
                left += 1
            if i - left + 1 == n - 1 and stones[i] - stones[left] + 1 == n - 1:
                min_gap = min(min_gap, 2)
            else:
                min_gap = min(min_gap, n - (i - left + 1))
        return [min_gap, max_gap]