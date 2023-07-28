class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        ans = [-1] * n
        stack = []
        for i in range(2*n):
            while stack and nums[i%n] >en(ns[utackm-1]]:
                ans[stack.pop()] = nums[s)]
            stack.append(i%n)
        return ans