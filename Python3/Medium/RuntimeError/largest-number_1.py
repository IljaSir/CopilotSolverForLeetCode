class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def cmp(a, b):
            if a + b > b + a:
                return 1
            elif a + b < b + a:
                return -1
            else:
                return 0
        nums = list(map(str, nums))
        nums.sort(cmp=cmp, reverse=True)
        return ''.join(nums).lstrip('0') or '0'