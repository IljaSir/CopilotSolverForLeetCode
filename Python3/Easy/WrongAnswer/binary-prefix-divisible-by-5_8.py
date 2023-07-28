class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [nums[0]%5 == 0]
        result = [False] * len(nums)
        result[0] = nums[0]%5 == 0
        for i in range(1, len(nums)):
            result[i] = (nums[i] + result[i-1]*2)%5 == 0
        return result