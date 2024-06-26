class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        stones.sort()
        while len(stones) > 1:
            x = stones.pop()
            y = stones.pop()
            if x != y:
                stones.append(x - y)
                stones.sort()
        return stones[0] if len(stones) == 1 else 0