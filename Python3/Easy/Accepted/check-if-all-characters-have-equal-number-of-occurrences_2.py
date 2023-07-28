class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        count = {}
        for c in s:
            if c in count:
                count[c] += 1
            else:
                count[c] = 1
        return len(set(count.values())) == 1