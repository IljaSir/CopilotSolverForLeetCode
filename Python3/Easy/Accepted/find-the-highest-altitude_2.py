class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        max_altitude = 0
        current_altitude = 0
        for altitude in gain:
            current_altitude += altitude
            max_altitude = max(current_altitude, max_altitude)
        return max_altitude