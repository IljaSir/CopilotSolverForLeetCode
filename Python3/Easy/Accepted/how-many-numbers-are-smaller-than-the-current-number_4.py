class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        
        return [sum([1 for j in nums if j < i]) for i in nums]