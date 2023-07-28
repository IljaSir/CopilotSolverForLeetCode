class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        def isSubseq(s, t):
            i = 0
            for c in s:
                i = t.find(c, i) + 1
                if i == 0:
                    return False
            return True
        return sum(isSubseq(w, s) for w in words)