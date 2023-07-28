class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        n = len(nums)
        change = [1] * n
        for i, x in enumerate(nums):
            change[(i-x+1)%n] -= 1
            change[(i+1)%n] += 1
        best = cur = 0
        for i in range(n):
            cur += change[i]
            if cur > best:
                best = cur
                ans = i
        return ans