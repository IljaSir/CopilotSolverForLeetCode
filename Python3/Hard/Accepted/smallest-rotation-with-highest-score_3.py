class Solution:
    def bestRotation(self, nums: List[int]) -> int:
        
        n = len(nums)
        changes = [0] * n
        for i, num in enumerate(nums):
            changes[(i - num + 1) % n] -= 1
        for i in range(1, n):
            changes[i] += changes[i - 1] + 1
        return changes.index(max(changes))