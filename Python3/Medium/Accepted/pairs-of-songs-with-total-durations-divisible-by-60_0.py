class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        
        res = 0
        count = [0] * 60
        for t in time:
            res += count[(60 - t % 60) % 60]
            count[t % 60] += 1
        return res