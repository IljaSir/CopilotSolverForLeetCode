class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        def f(s):
            return (tuple(sorted(s[::2])), tuple(sorted(s[1::2])))
        return len({f(w) for w in words})