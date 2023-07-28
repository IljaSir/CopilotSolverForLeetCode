class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        # Solution 1: 92 ms
        # return sum((Counter(t) - Counter(s)).values())
        # Solution 2: 76 ms
        return sum(max(t.count(c) - s.count(c), 0) for c in set(s))