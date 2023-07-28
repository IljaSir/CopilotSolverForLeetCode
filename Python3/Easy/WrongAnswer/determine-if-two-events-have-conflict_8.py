class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        # convert to minutes
        def to_minutes(time):
            h, m = time.split(':')
            return int(h) * 60 + int(m)
        s1, e1 = to_minutes(event1[0]), to_minutes(event1[1])
        s2, e2 = to_minutes(event2[0]), to_minutes(event2[1])
        # check if there is a conflict
        return (s1 <= s2 < e1) or (s2 <= s1 < e2)