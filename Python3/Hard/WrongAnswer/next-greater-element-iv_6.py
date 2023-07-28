class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        
        stack = []
        n = len(nums)
        ans = [-1] * n
        for i in range(n):
            while stack and nums[stack[-1]] < nums[i]:
                ans[stack.pop()] = nums[i]
            stack.append(i)
        return ans