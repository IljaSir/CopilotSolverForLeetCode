class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        nums = sorted(nums, key=lambda x: (str(x)[0], str(x)))
        s = ''.join([str(x) for x in nums])
        return s