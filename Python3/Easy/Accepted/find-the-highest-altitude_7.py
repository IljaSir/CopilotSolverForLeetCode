class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        max_altitude = 0
        altitude = 0
        for gain_i in gain:
            altitude += gain_i
            max_altitude = max(max_altitude, altitude)
        return max_altitude