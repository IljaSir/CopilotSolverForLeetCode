class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        return len([x for x in rectangles if x[0] == max(rectangles, key = lambda x: x[0])[0] or x[1] == max(rectangles, key = lambda x: x[1])[1]])