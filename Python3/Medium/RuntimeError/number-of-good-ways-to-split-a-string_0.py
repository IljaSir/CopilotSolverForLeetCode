class Solution:
    def numSplits(self, s: str) -> int:
        
        left = set()
        right = set(s)
        count = 0
        for c in s:
            left.add(c)
            right.remove(c)
            if len(left) == len(right):
                count += 1
        return count