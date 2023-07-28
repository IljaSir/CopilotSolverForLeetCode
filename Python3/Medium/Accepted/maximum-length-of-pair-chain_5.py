class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        
        pairs.sort(key=lambda x: x[1])
        curr = pairs[0][1]
        res = 1
        for p in pairs[1:]:
            if curr < p[0]:
                curr = p[1]
                res += 1
        return res