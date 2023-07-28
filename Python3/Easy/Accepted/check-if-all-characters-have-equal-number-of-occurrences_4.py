class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        counts = {}
        for c in s:
            if c not in counts:
                counts[c] = 1
            else:
                counts[c] += 1
        unique_counts = set(counts.values())
        return len(unique_counts) == 1