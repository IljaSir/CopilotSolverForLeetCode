class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        # O(N^2)
        # ans = [-1] * len(nums)
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[j] > nums[i]:
        #             ans[i] = nums[j]
        #             break
        #     if ans[i] == -1:
        #         for j in range(i):
        #             if nums[j] > nums[i]:
        #                 ans[i] = nums[j]
        #                 break
        # return ans
        # O(N)
        ans = [-1] * len(nums)
        stack = []
        for i in range(2*len(nums)):
            while stack and nums[stack[-1]] < nums[i%len(nums)]:
                ans[stack.pop()] = nums[i%len(nums)]
            stack.append(i%len(nums))
        return ans