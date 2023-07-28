class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        
        stack = []
        ans = [-1] * len(nums)
        for i, n in enumerate(nums):
            while stack and nums[stack[-1]] < n:
                ans[stack.pop()] = n
            stack.append(i)
        return ans