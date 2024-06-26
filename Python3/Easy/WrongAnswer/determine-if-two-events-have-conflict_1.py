class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        start1, end1 = event1
        start2, end2 = event2
        return start1 < end2 and start2 < end1