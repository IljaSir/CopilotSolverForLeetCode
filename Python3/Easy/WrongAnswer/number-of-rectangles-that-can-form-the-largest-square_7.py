class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        return sum([1 for i in rectangles if min(i) == max(rectangles, key=lambda x: min(x))[0]])