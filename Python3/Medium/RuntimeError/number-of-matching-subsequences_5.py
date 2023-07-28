class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        res = 0
        for word in words:
            if self.is_subsequence(s, word):
                res += 1
        return res