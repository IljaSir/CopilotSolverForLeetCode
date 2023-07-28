class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        
        return [i for i in set(nums) if nums.count(i) == 2]