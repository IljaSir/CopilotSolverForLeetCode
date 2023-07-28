class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        d = {0:0}
        c = 0
        r = 0
        for i, n in enumerate(nums):
            c += 1 if n else -1
            if c in d:
                r = max(r, i + 1 - d[c])
            else:
                d[c] = i + 1
        return r