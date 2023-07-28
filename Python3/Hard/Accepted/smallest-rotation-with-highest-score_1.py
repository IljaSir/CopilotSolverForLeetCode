class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        n = len(nums)
        change = [0] * n
        for i, x in enumerate(nums):
            change[(i - x + 1) % n] -= 1
        for i in range(1, n):
            change[i] += change[i - 1] + 1
        return change.index(max(change))