class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        
        a, b, c = sorted([a, b, c])
        min_moves = 2
        max_moves = c - a - 2
        if b - a <= 2 or c - b <= 2:
            min_moves = 1
        if b - a == 1 and c - b == 1:
            min_moves = 0
        return [min_moves, max_moves]