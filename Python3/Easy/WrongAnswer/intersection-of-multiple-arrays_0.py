class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        
        return list(set(nums[0]).intersection(*nums))