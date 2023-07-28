class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        
        count = 0
        for word in set(words1):
            if words1.count(word) == 1 and words2.count(word) == 1:
                count += 1
        for word in set(words2):
            if words1.count(word) == 1 and words2.count(word) == 1:
                count += 1
        return count