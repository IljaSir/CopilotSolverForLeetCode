class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        
        return max([len(s) if not s.isdigit() else int(s) for s in strs])