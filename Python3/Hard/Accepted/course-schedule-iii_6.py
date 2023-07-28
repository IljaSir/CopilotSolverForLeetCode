class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        
        courses.sort(key=lambda x:x[1])
        time, heap = 0, []
        for t, e in courses:
            heappush(heap, -t)
            time += t
            if time > e:
                time += heappop(heap)
        return len(heap)