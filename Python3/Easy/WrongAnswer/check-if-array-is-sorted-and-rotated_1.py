class Solution:
    def check(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)):
            if nums[i] > nums[(i+1)%len(nums)]:
                return False
        return True