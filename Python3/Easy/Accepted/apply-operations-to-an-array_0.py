class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        for i in range(n-1):
            if nums[i] == nums[i+1]:
                nums[i] *= 2
                nums[i+1] = 0
        return [x for x in nums if x != 0] + [0] * nums.count(0)