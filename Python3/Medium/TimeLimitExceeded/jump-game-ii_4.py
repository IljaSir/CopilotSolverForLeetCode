class Solution:
    def jump(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return 0
        if nums[0] >= n - 1:
            return 1
        if nums[0] == 0:
            return float("inf")
        min_jump = float("inf")
        for i in range(1, nums[0] + 1):
            min_jump = min(min_jump, 1 + self.jump(nums[i:]))
        return min_jump