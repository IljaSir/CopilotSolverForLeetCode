class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        
        return [sum(1 for n in nums if n < num) for num in nums]