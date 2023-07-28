class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x: x[1])
        time = 0
        heap = []
        for duration, lastDay in courses:
            if time + duration <= lastDay:
                heapq.heappush(heap, -duration)
                time += duration
            elif heap and -heap[0] > duration:
                time += heapq.heappop(heap) + duration
                heapq.heappush(heap, -duration)
        return len(heap)