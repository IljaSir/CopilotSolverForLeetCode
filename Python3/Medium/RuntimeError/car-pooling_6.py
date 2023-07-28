class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        # 1st solution
        # O(nlogn) time | O(n) space
        # n = len(trips)
        # trips.sort(key=lambda x: (x[1], x[2]))
        # for i in range(n - 1):
        #     if trips[i][2] > trips[i + 1][1]:
        #         trips[i + 1][0] += trips[i][0]
        #     if trips[i + 1][0] > capacity:
        #         return False
        # return trips[-1][0] <= capacity
        
        # 2nd solution
        # O(n) time | O(n) space
        # n = len(trips)
        # trips.sort(key=lambda x: x[1])
        # trips.sort(key=lambda x: x[2])
        # i = 0
        # while i < n and trips[i][2] <= trips[0][1]:
        #     i += 1
        # for j in range(i, n):
        #     trips[j][0] += trips[j - 1][0]
        #     if trips[j][0] > capacity:
        #         return False
        # return trips[-1][0] <= capacity
        
        # 3rd solution
        # O(n) time | O(n) space
        # n = len(trips)
        # trips.sort(key=lambda x: x[1])
        # trips.sort(key=lambda x: x[2])
        # i = 0
        # while i < n and trips[i][2] <= trips[0][1]:
        #     i += 1
        # for j in range(i, n):
        #     trips[j][0] += trips[j - 1][0]
        #     if trips[j][0] > capacity:
        #         return False
        # return trips[-1][0] <= capacity
        
        # 4th solution
        # O(n) time | O(n) space
        # n = len(trips)
        # trips.sort(key=lambda x: x[1])
        # trips.sort(key=lambda x: x[2])
        # i = 0
        # while i < n and trips[i][2] <= trips[0][1]:
        #     i += 1
        # for j in