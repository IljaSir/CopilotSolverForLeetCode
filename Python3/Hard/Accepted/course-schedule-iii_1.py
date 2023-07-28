class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x: x[1])
        heap = []
        time = 0
        for t, end in courses:
            if time + t <= end:
                time += t
                heapq.heappush(heap, -t)
            elif heap and -heap[0] > t:
                time += t + heapq.heappop(heap)
                heapq.heappush(heap, -t)
        return len(heap)