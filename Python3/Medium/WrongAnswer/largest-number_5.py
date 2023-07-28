class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        return str(int(''.join(sorted(map(str, nums), key=lambda x: x*4, reverse=True))))