class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        def get_key(s):
            even = sorted(s[::2])
            odd = sorted(s[1::2])
            return ''.join(even+odd)
        return len({get_key(w) for w in words})