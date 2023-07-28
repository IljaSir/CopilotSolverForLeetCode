class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        
        stack = []
        res = [-1] * len(nums)
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]:
                res[stack.pop()] = nums[i]
            stack.append(i)
        return res