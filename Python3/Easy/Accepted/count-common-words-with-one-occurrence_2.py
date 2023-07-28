class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        return len(set([w for w in words1 if words1.count(w) == 1 and words2.count(w) == 1]) | set([w for w in words2 if words1.count(w) == 1 and words2.count(w) == 1]))