class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        
        max_size = 0
        count = 0
        for rec in rectangles:
            size = min(rec)
            if size > max_size:
                max_size = size
                count = 1
            elif size == max_size:
                count += 1
        return count