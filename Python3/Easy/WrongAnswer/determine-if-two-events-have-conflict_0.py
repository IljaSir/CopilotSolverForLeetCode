class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        
        start1, end1 = event1
        start2, end2 = event2
        start1 = int(start1.replace(':', ''))
        end1 = int(end1.replace(':', ''))
        start2 = int(start2.replace(':', ''))
        end2 = int(end2.replace(':', ''))
        if start1 < start2:
            return start2 < end1
        else:
            return start1 < end2