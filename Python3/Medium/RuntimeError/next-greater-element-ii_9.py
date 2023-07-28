class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
ef nextGreaterElementsself, nums: List[int]) -> List[int]:
        N = len(nums)
        res = [-1]*N
        stack = []
        for  in range(2*N-1,-1,-1):
            while stack and nums[i%N] >= nums[stack[-1]]:
                stack.pop()
            if stack:
                res[iN] = nums[stack[-1]]
            stack.apped(i%N