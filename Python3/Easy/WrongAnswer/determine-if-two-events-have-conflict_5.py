class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        def to_minutes(s):
            h, m = map(int, s.split(':'))
            return h * 60 + m
        return not (to_minutes(event1[1]) <= to_minutes(event2[0]) or to_minutes(event2[1]) <= to_minutes(event1[0]))