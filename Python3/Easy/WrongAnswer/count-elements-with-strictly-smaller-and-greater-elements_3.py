class Solution:
    def countElements(self, nums: List[int]) -> int:
        
        return sum(1 for i in nums if i-1 in nums and i+1 in nums)