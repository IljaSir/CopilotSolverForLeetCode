class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        return len({tuple(sorted(s[::2]) + sorted(s[1::2])) for s in words})