class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        
        # Binary search on the time
        # Check if the total number of trips is less than totalTrips
        # If it is, increase the time
        # If it is not, decrease the time
        # Return the time
        
        start = 0
        end = max(time) * totalTrips
        
        while start <= end:
            
            mid = (start + end) // 2
            
            if self.check(time, mid, totalTrips):
                start = mid + 1
            else:
                end = mid - 1
                
        return start