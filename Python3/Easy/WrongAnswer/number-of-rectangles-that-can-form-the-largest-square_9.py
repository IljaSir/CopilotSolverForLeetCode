class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        return sum([1 for x in rectangles if x[0] == x[1]])