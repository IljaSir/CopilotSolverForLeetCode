class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        highest_altitude = 0
        current_altitude = 0
        for altitude_change in gain:
            current_altitude += altitude_change
            if current_altitude > highest_altitude:
                highest_altitude = current_altitude
        return highest_altitude