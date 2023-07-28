class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        
        return [x for x in nums if nums.count(x) == 1]