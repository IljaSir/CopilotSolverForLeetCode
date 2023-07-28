class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        def convert_to_minutes(event):
            start, end = event
            start_hour, start_minute = map(int, start.split(':'))
            end_hour, end_minute = map(int, end.split(':'))
            return start_hour * 60 + start_minute, end_hour * 60 + end_minute
        start1, end1 = convert_to_minutes(event1)
        start2, end2 = convert_to_minutes(event2)
        return (start1 <= start2 < end1) or (start2 <= start1 < end2)