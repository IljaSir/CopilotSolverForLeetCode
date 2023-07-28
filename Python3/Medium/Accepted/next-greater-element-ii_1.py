class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        res = [-1] * n
        stack = []
        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                res[stack.pop()] = nums[i]
            stack.append(i)
        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                res[stack.pop()] = nums[i]
        return res