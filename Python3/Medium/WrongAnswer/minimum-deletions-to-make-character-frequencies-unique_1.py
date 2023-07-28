class Solution:
    def minDeletions(self, s: str) -> int:
        
        from collections import Counter
        counts = Counter(s)
        # print(counts)
        # print(counts.values())
        # print(set(counts.values()))
        # print(len(counts.values()))
        # print(len(set(counts.values())))
        return len(counts.values()) - len(set(counts.values()))