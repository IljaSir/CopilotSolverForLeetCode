class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        return str(int(''.join(sorted([str(x) for x in nums], key=lambda x: x*3, reverse=True))))