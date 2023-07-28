class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        from collections import Counter
        words2_count = Counter()
        for word in words2:
            words2_count |= Counter(word)
        return [word for word in words1 if not words2_count - Counter(word)]