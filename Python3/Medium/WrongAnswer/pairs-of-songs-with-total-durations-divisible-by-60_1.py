class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        
        from collections import Counter
        c = Counter()
        for t in time:
            c[60 - t % 60] += 1
        return sum(c[k] * v for k, v in c.items() if k <= 30) // 2