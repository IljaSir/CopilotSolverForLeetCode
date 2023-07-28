class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        return len(list(filter(lambda x: x == max(map(lambda y: min(y), rectangles)), map(lambda x: min(x), rectangles))))