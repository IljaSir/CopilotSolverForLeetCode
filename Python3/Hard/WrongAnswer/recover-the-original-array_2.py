class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        k = (nums[-1] - nums[0]) // (len(nums) - 1)
        return [nums[i] - k * i for i in range(len(nums))]