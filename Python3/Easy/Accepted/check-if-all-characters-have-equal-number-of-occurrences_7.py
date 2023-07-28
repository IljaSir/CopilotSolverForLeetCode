class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        
        # 1st solution
        # return len(set(s.count(c) for c in s)) == 1
        # 2nd solution
        # return len(set(s.count(c) for c in set(s))) == 1
        # 3rd solution
        return len(set(s.count(c) for c in s)) == 1