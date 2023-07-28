class Solution:
    def check(self, nums: List[int]) -> bool:
        
        return all(nums[i] <= nums[i+1] for i in range(len(nums)-1))