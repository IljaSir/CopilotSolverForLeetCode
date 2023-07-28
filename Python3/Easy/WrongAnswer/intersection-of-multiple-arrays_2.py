class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        
        return set(nums[0]).intersection(*nums[1:])