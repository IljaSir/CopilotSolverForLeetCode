class Solution:
    def maximumValue(self, strs: List[str]) -> int:
        
        return max(map(lambda s: len(s) if s.isalpha() else int(s), strs))