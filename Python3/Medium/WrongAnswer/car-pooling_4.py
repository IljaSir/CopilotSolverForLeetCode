class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        trips.sort(key=lambda x: x[1])
        for i in range(len(trips)):
            trips[i].append(trips[i][0])
        while True:
            for i in range(len(trips)):
                if trips[i][2] > 0:
                    capacity -= trips[i][0]
                    trips[i][2] -= 1
                    if capacity < 0:
                        return False
            if all([trip[2] == 0 for trip in trips]):
                return True