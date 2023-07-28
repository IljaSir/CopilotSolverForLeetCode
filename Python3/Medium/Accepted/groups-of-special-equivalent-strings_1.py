class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        return len({(''.join(sorted(w[::2])) + ''.join(sorted(w[1::2]))) for w in words})