class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        res = []
        for i in range(len(nums)):
            res.append(sum([1 for j in range(i+1, len(nums)) if nums[j] < nums[i]]))
        return res