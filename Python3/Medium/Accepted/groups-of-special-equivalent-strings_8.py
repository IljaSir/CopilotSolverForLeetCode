class Solution:
    def numSpecialEquivGroups(self, words: List[str]) -> int:
        
        def f(s):
            return ("".join(sorted(s[::2])),"".join(sorted(s[1::2])))
        return len(set(f(s) for s in words))