class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n == 1:
            return True
        jump = nums[0]
        for i in range(1, n):
            if jump == 0:
                return False
            if jump < i:
                return False
            jump = max(jump, i + nums[i])
        return True