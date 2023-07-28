class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        nums = [str(x) for x in nums]
        nums.sort(key=lambda x: x*10, reverse=True)
        return str(int(''.join(nums)))