class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        stones.sort()
        while len(stones) > 1:
            stones.sort()
            if stones[-1] == stones[-2]:
                stones.pop()
                stones.pop()
            else:
                stones[-2] = stones[-1] - stones[-2]
                stones.pop()
        if len(stones) == 1:
            return stones[0]
        else:
            return 0