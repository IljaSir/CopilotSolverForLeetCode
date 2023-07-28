class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        N = len(nums)
        bad = [0] * N
        for i, x in enumerate(nums):
            left = (i - x + 1 + N) % N
            right = (i + 1) % N
            bad[left] -= 1
            bad[right] += 1
            if left > right:
                bad[0] -= 1
        best = -N
        ans = cur = 0
        for i, x in enumerate(bad):
            cur += x
            if cur > best:
                best = cur
                ans = i
        return ans