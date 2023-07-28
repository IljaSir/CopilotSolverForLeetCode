class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)):
            # print(nums[:i] + nums[i+1:])
            if self.isStrictlyIncreasing(nums[:i] + nums[i+1:]):
                return True
        return False