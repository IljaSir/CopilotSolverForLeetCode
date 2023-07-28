class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        
        stones = sorted([a, b, c])
        if stones[2] - stones[0] == 2:
            return [0, 0]
        else:
            min_moves = 2
            if stones[2] - stones[1] <= 2 or stones[1] - stones[0] <= 2:
                min_moves = 1
            return [min_moves, stones[2] - stones[0] - 2]