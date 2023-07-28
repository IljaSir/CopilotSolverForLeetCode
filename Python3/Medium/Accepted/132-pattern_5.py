class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        
        stack = []
        s3 = -float('inf')
        for n in reversed(nums):
            if n < s3:
                return True
            while stack and n > stack[-1]:
                s3 = stack.pop()
            stack.append(n)
        return False