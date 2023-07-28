class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        return len([r for r in rectangles if r[0] == r[1]])