class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        
        return max(len(s) if s.isalpha() else int(s) for s in strs)