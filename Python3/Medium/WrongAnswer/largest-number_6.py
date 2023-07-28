class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        if max(nums) == 0:
            return "0"
        return "".join(sorted([str(i) for i in nums], key = lambda x: x*4, reverse = True))