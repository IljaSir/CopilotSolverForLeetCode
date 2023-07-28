class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        
        if len(nums) < 2:
            return len(nums)
        up = [1] * len(nums)
        down = [1] * len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    up[i] = max(up[i], down[j] + 1)
                elif nums[i] < nums[j]:
                    down[i] = max(down[i], up[j] + 1)
        return max(up[-1], down[-1])