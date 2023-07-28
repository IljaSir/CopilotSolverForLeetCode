class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def cmp(a, b):
            if a + b > b + a:
                return -1
            elif a + b == b + a:
                return 0
            else:
                return 1
        nums = list(map(str, nums))
        nums.sort(key=functools.cmp_to_key(cmp))
        return str(int(''.join(nums)))