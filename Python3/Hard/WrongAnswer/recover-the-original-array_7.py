class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums = sorted(nums)
        k = nums[len(nums)//2] - nums[(len(nums)//2)-1]
        return [n-k for n in nums]