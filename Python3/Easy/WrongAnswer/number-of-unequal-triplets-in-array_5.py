class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        
        nums.sort()
        return sum((nums[i] != nums[i+1] and nums[i+1] != nums[i+2] and nums[i] != nums[i+2]) for i in range(len(nums)-2))