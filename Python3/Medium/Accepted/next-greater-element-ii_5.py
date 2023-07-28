class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        N = len(nums)
        stack = []
        res = [-1] * N
        for i in range(N * 2):
            while stack and nums[stack[-1]] < nums[i % N]:
                res[stack.pop()] = nums[i % N]
            stack.append(i % N)
        return res