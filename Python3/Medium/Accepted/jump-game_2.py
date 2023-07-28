class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n == 1:
            return True
        if nums[0] == 0:
            return False
        for i in range(n-1):
            if nums[i] == 0:
                j = i-1
                while j >= 0:
                    if j + nums[j] > i:
                        break
                    j -= 1
                if j < 0:
                    return False
        return True