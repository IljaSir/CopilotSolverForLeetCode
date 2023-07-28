class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 1:
            return [nums]
        res = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            for perm in self.permuteUnique(nums[:i] + nums[i+1:]):
                res.append([nums[i]] + perm)
        return res