class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        
        a, b, c = sorted([a, b, c])
        if c - a == 2:
            return [0, 0]
        if a + 1 == b or b + 1 == c:
            return [1, c - a - 2]
        if a + 2 == b or b + 2 == c:
            return [1, c - a - 2]
        return [2, c - a - 2]