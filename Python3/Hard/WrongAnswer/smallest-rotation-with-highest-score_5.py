class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        n = len(nums)
        change = [0] * n
        for i, x in enumerate(nums):
            change[(i - x + 1) % n] -= 1
        best = cur = -n
        res = 0
        for i, x in enumerate(change):
            cur += x
            if cur > best:
                best = cur
                res = i
        return res