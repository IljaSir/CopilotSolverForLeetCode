class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        
        nums.sort(key=abs)
        return nums[0]