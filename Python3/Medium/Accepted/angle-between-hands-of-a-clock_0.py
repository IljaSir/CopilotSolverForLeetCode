class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        
        hour = hour % 12
        hour_angle = 0.5 * (60 * hour + minutes)
        minutes_angle = 6 * minutes
        angle = abs(hour_angle - minutes_angle)
        if angle > 180:
            angle = 360 - angle
        return angle