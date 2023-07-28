class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x: x[1])
        heap = []
        time = 0
        for duration, lastDay in courses:
            if time + duration <= lastDay:
                heapq.heappush(heap, -duration)
                time += duration
            elif heap and -heap[0] > duration:
                time += heapq.heappushpop(heap, -duration) + duration
        return len(heap)