class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) <= 1:
            return [nums]
        else:
            return [ [nums[i]] + p for i in range(len(nums)) for p in self.permute(nums[:i] + nums[i+1:]) ]