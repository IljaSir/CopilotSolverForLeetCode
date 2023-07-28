class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        def get_time(event):
            start, end = event
            start_hour, start_minute = start.split(":")
            end_hour, end_minute = end.split(":")
            start_hour, start_minute = int(start_hour), int(start_minute)
            end_hour, end_minute = int(end_hour), int(end_minute)
            return start_hour, start_minute, end_hour, end_minute
        s1, m1, e1, m2 = get_time(event1)
        s2, m2, e2, m2 = get_time(event2)
        if e1 < s2 or s1 > e2:
            return False
        return True