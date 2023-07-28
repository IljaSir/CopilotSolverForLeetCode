class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        if len(nums) < 3:
            return False
        stack = []
        minnum = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > minnum:
                while stack and stack[-1] <= minnum:
                    stack.pop()
                if stack and stack[-1] < nums[i]:
                    return True
                stack.append(nums[i])
            else:
                minnum = nums[i]
        return False