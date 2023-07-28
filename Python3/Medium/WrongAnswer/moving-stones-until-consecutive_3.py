class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        
        a,b,c = sorted([a,b,c])
        if c-b == 1 and b-a == 1:
            return [0,0]
        elif c-b == 2 or b-a == 2:
            return [1,max(c-b-1,b-a-1)]
        else:
            return [2,c-b+b-a-2]