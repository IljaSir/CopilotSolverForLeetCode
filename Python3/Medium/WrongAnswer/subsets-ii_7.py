class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        res = [[]]
        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                res += [j + [nums[i]] for j in res[-len(res)//2:]]
            else:
                res += [j + [nums[i]] for j in res]
        return res