class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        
        return max(sum(c.isdigit() for c in s) or len(s) for s in strs)