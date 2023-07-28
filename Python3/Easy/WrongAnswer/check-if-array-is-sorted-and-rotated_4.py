class Solution:
    def check(self, nums: List[int]) -> bool:
        
        return all(nums[i] <= nums[(i+1) % len(nums)] for i in range(len(nums)))