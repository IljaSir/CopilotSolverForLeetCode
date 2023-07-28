class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        n = len(nums)
        diff = [0] * n
        for i, num in enumerate(nums):
            left = (i - num + 1 + n) % n
            right = (i + 1) % n
            diff[left] -= 1
            diff[right] += 1
            if left > right:
                diff[0] -= 1
        best = -n
        ans = cur = 0
        for i, d in enumerate(diff):
            cur += d
            if cur > best:
                best = cur
                ans = i
        return ans