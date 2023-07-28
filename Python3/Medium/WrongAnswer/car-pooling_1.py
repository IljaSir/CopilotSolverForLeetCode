class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        trips.sort(key=lambda x: x[1])
        trips.sort(key=lambda x: x[2])
        for i in range(len(trips)):
            if trips[i][0] > capacity:
                return False
            capacity -= trips[i][0]
            for j in range(i+1, len(trips)):
                if trips[j][1] >= trips[i][2]:
                    break
                if trips[j][0] > capacity:
                    return False
                capacity -= trips[j][0]
        return True