class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        # 1. Sort the trips by the starting point
        # 2. Iterate through the trips
        #   2.1. If the current trip is not overlapping with the previous one, then add the number of passengers to the total
        #   2.2. If the current trip is overlapping with the previous one, then subtract the number of passengers from the total
        #   2.3. If the total number of passengers is greater than the capacity, then return false
        # 3. Return true
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        trips.sort(key=lambda x: x[1])
        total = 0
        for trip in trips:
            total += trip[0]
            if total > capacity:
                return False
        return True