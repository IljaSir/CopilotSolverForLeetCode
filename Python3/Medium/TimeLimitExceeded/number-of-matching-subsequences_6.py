class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        def is_subsequence(s, t):
            it = iter(t)
            return all(c in it for c in s)
        
        count = 0
        for w in words:
            if is_subsequence(w, s):
                count += 1
        return count