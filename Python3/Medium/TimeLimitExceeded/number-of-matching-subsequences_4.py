class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        def isSubseq(s, t):
            i = 0
            for c in t:
                if i < len(s) and c == s[i]:
                    i += 1
            return i == len(s)
        return sum(isSubseq(w, s) for w in words)