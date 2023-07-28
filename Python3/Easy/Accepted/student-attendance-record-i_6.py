class Solution:
    def checkRecord(self, s: str) -> bool:
        
        return not (s.count("A") > 1 or "LLL" in s)