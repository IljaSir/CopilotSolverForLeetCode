class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        # Determine the slope of the first two points
        # If any other points have a different slope, return False
        # If all points have the same slope, return True
        
        # If there are only two points, return True
        if len(coordinates) == 2:
            return True
        
        # Determine the slope of the first two points
        x1, y1 = coordinates[0]
        x2, y2 = coordinates[1]
        if x1 == x2:
            slope = "vertical"
        else:
            slope = (y2-y1) / (x2-x1)
        
        # If any other points have a different slope, return False
        # If all points have the same slope, return True
        for i in range(2, len(coordinates)):
            x1, y1 = coordinates[i-1]
            x2, y2 = coordinates[i]
            if x1 == x2:
                slope2 = "vertical"
            else:
                slope2 = (y2-y1) / (x2-x1)
            if slope != slope2:
                return False
        return True