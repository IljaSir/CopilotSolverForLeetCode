class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        stack = []
        max_k = -float('inf')
        for i in range(len(nums)-1, -1, -1):
            if nums[i] < max_k:
                return True
            while stack and nums[i] > stack[-1]:
                max_k = stack.pop()
            stack.append(nums[i])
        return False