class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def cmp(a, b):
            return [1, -1][a+b > b+a]
        nums = sorted(map(str, nums), cmp=cmp, reverse=True)
        return str(int(''.join(nums)))