class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        # sort by lastDay
        courses.sort(key=lambda x: x[1])
        #print(courses)
        # max heap
        heap = []
        # start from day 1
        day = 1
        for duration, lastDay in courses:
            #print(day, duration, lastDay, heap)
            # if day + duration <= lastDay, we can take the course
            if day + duration <= lastDay:
                # take the course
                heapq.heappush(heap, -duration)
                day += duration
            # if day + duration > lastDay, we need to check if we can take the course
            elif heap and -heap[0] > duration:
                # take the course
                day += duration + heapq.heappop(heap)
                heapq.heappush(heap, -duration)
        #print(heap)
        return len(heap)