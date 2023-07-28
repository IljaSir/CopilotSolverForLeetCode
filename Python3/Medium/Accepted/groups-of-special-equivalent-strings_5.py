class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        def key(word):
            return tuple(sorted(word[::2])) + tuple(sorted(word[1::2]))
        return len({key(word) for word in words})