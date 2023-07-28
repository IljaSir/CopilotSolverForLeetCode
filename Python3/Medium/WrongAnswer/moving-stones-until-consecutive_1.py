class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        
        a, b, c = sorted([a, b, c])
        if c - a == 2:
            return [0, 0]
        if c - a == 3:
            return [1, 2]
        if b - a == 2 or c - b == 2:
            return [1, c - a - 2]
        return [2, c - a - 2]