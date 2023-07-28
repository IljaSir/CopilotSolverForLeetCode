class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        n = len(gain)
        max_altitude = 0
        curr_altitude = 0
        for i in range(n):
            curr_altitude += gain[i]
            max_altitude = max(max_altitude, curr_altitude)
        return max_altitude