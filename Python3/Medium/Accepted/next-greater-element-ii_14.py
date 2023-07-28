class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        N = len(nums)
        res = [-1] * N
        stack = []
        for i in range(2*N):
            while stack and nums[stack[-1]] < nums[i % N]:
                res[stack.pop()] = nums[i % N]
            stack.append(i % N)
        return res