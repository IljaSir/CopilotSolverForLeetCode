class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        if len(stones) == 1:
            return stones[0]
        stones.sort()
        while len(stones) > 1:
            if stones[-1] == stones[-2]:
                stones = stones[:-2]
            else:
                stones[-2] = stones[-1] - stones[-2]
                stones = stones[:-1]
                stones.sort()
        return 0 if len(stones) == 0 else stones[0]