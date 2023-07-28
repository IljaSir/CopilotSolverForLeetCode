class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        trips.sort(key=lambda x: x[1])
        for trip in trips:
            if trip[0] > capacity:
                return False
            capacity -= trip[0]
            for trip_ in trips:
                if trip_[1] >= trip[2]:
                    break
                if trip_[1] > trip[1]:
                    capacity += trip_[0]
        return True