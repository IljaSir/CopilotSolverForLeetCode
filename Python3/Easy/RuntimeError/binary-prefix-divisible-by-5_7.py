class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        
        result = []
        for i in range(len(nums)):
            result.append(self.is_divisible_by_5(nums[0:i+1]))
        return result