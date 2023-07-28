class Solution:
    def numSplits(self, s: str) -> int:
        
        res = 0
        left = set()
        right = set(s)
        for c in s:
            left.add(c)
            right.remove(c)
            if len(left) == len(right):
                res += 1
        return res