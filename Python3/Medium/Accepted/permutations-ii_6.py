class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = []
        def backtrack(nums, tmp):
            if not nums:
                res.append(tmp)
                return
            for i, n in enumerate(nums):
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                backtrack(nums[:i]+nums[i+1:], tmp+[n])
        backtrack(nums, [])
        return res