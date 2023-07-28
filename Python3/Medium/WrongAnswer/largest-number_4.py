class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        nums = [str(n) for n in nums]
        nums.sort(key = lambda x: x*3, reverse = True)
        return str(int(''.join(nums)))