class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        
        return [n for i, n in enumerate(nums) if n not in nums[:i] + nums[i+1:]]