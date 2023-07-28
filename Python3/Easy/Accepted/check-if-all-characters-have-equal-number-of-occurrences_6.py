class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        count = collections.Counter(s).values()
        return len(set(count)) == 1