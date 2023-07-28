class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def compare(a, b):
            if a + b > b + a:
                return 1
            elif a + b < b + a:
                return -1
            else:
                return 0
        nums = [str(x) for x in nums]
        nums.sort(key=functools.cmp_to_key(compare), reverse=True)
        return ''.join(nums).lstrip('0') or '0'