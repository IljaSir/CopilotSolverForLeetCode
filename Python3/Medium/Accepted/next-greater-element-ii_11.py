class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        res = [-1] * len(nums)
        stack = []
        for i in range(len(nums)*2):
            while stack and nums[stack[-1]] < nums[i%len(nums)]:
                res[stack.pop()] = nums[i%len(nums)]
            stack.append(i%len(nums))
        return res