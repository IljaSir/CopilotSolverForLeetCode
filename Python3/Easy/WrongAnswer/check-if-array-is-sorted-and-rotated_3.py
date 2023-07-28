class Solution:
    def check(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n == 1:
            return True
        if n == 2:
            return nums[0] <= nums[1]
        for i in range(n):
            if nums[i] > nums[(i+1)%n]:
                return False
        return True