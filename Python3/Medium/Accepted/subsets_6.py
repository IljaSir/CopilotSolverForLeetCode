class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 0:
            return [[]]
        if len(nums) == 1:
            return [[], nums]
        sub = self.subsets(nums[1:])
        return sub + [[nums[0]] + s for s in sub]