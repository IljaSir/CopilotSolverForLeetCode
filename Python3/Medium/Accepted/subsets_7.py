class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        result = []
        def backtrack(nums, temp):
            result.append(temp)
            for i in range(len(nums)):
                backtrack(nums[i+1:], temp + [nums[i]])
        backtrack(nums, [])
        return result