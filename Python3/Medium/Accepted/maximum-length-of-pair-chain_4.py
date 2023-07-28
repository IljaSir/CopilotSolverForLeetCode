class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        
        pairs.sort(key=lambda x: x[1])
        ans, last = 0, float('-inf')
        for p in pairs:
            if p[0] > last:
                ans += 1
                last = p[1]
        return ans