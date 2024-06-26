class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        stack = []
        m = float('-inf')
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] < m:
                return True
            while stack and stack[-1] < nums[i]:
                m = stack.pop()
            stack.append(nums[i])
        return False