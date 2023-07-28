class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        
        n = len(nums)
        stack = []
        for i in range(n):
            while stack and nums[i] < stack[-1] and len(stack) + n - i > k:
                stack.pop()
            if len(stack) < k:
                stack.append(nums[i])
        return stack