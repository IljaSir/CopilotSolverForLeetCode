class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        # Time  complexity: O(nlogn)
        # Space complexity: O(n)
        stops = []
        for num_passengers, start, end in trips:
            stops.append((start, num_passengers))
            stops.append((end, -num_passengers))

        stops.sort()

        current_passengers = 0
        for _, num_passengers in stops:
            current_passengers += num_passengers
            if current_passengers > capacity:
                return False

        return True