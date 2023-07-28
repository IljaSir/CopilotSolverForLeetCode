class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        n = len(nums)
        k = (nums[n//2] - nums[n//2-1])//2
        return [i+k for i in nums]