class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        return len({tuple(sorted(word[0::2]) + sorted(word[1::2])) for word in words})