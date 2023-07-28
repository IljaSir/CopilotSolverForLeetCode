class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x: x[1])
        pq = []
        time = 0
        for t, end in courses:
            if time + t <= end:
                heapq.heappush(pq, -t)
                time += t
            elif pq and -pq[0] > t:
                time += heapq.heappushpop(pq, -t) + t
        return len(pq)