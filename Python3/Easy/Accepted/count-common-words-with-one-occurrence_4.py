class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        return sum(1 for word in set(words1 + words2) if (words1.count(word) == 1 and words2.count(word) == 1))