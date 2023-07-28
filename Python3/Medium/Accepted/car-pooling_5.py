class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        if len(trips) == 0:
            return True
        trips.sort(key=lambda x: x[1])
        trips.sort(key=lambda x: x[2])
        time = [[0, 0] for _ in range(1001)]
        for trip in trips:
            time[trip[1]][0] += trip[0]
            time[trip[2]][1] += trip[0]
        for i in range(1, 1001):
            time[i][0] += time[i - 1][0]
            time[i][1] += time[i - 1][1]
        for i in range(1001):
            if time[i][0] - time[i][1] > capacity:
                return False
        return True