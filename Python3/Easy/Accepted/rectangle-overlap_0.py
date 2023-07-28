class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        
        
        # Check if the two rectangles overlap
        # @param: x1, y1, x2, y2: Coordinates of the two rectangles
        # @return: True if the two rectangles overlap, False otherwise
        # @complexity: O(1)
        # @space_complexity: O(1)
        
        # Check if the two rectangles overlap
        # @param: x1, y1, x2, y2: Coordinates of the two rectangles
        # @return: True if the two rectangles overlap, False otherwise
        # @complexity: O(1)
        # @space_complexity: O(1)
        def is_overlap(x1, y1, x2, y2):
            return x1 < x2 and y1 < y2
        
        return is_overlap(rec1[0], rec1[1], rec2[2], rec2[3]) and is_overlap(rec2[0], rec2[1], rec1[2], rec1[3])