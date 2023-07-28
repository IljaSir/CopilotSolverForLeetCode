class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        max_len = 0
        for rect in rectangles:
            max_len = max(max_len, min(rect[0], rect[1]))
        count = 0
        for rect in rectangles:
            if min(rect[0], rect[1]) == max_len:
                count += 1
        return count