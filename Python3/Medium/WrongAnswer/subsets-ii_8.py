class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums = sorted(nums)
        res = [[]]
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                res += [x + [nums[i]] for x in res[-len(res)//2:]]
            else:
                res += [x + [nums[i]] for x in res]
        return res