class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n < 3:
            return False
        left_min = [nums[0]]
        for i in range(1, n):
            left_min.append(min(left_min[-1], nums[i]))
        stack = []
        for j in range(n-1, -1, -1):
            if nums[j] > left_min[j]:
                while stack and stack[-1] <= left_min[j]:
                    stack.pop()
                if stack and stack[-1] < nums[j]:
                    return True
                stack.append(nums[j])
        return False