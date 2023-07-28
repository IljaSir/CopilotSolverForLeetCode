class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        count = 0
        for word in words:
            if self.is_subsequence(s, word):
                count += 1
        return count