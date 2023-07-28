class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        
        pairs.sort(key=lambda x: x[1])
        res = 0
        curr = -float('inf')
        for a, b in pairs:
            if a > curr:
                res += 1
                curr = b
        return res