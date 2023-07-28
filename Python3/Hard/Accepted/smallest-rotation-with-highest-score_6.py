class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        N = len(nums)
        change = [1] * N
        for i, x in enumerate(nums):
            change[(i - x + 1) % N] -= 1
        best = -N
        ans = cur = 0
        for i, x in enumerate(change):
            cur += x
            if cur > best:
                best = cur
                ans = i
        return ans