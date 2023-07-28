class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        
        return [i for i in nums if nums.count(i) == 1]