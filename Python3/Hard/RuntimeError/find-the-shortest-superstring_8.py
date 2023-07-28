class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        def overlap(a, b):
            for i in range(min(len(a), len(b)), 0, -1):
                if a[-i:] == b[:i]: return i
            return 0
        def find_overlap(a, b):
            if len(a) == 0: return b
            if len(b) == 0: return a
            if a[-1] == b[0]: return a + b[1:]
            if a[0] == b[-1]: return b + a[1:] overlap(words[i], words[res]):
                    res = i
                   brreak
        return res