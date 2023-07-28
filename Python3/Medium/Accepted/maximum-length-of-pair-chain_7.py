class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        
        pairs.sort(key=lambda x: x[1])
        prev = -1001
        ans = 0
        for pair in pairs:
            if pair[0] > prev:
                prev = pair[1]
                ans += 1
        return ans