class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x: x[1])
        pq = []
        t = 0
        for dur, end in courses:
            t += dur
            heapq.heappush(pq, -dur)
            if t > end:
                t += heapq.heappop(pq)
        return len(pq)