class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        maxLen = 0
        for rectangle in rectangles:
            maxLen = max(maxLen, min(rectangle))
        count = 0
        for rectangle in rectangles:
            if min(rectangle) == maxLen:
                count += 1
        return count