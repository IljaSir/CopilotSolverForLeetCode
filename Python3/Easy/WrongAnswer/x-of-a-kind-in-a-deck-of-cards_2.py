class Solution:
    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        
        from collections import Counter
        counts = Counter(deck)
        min_count = min(counts.values())
        return min_count > 1 and all(count % min_count == 0 for count in counts.values())