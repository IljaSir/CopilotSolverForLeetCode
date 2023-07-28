class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        nums = sorted(map(str, nums), key=functools.cmp_to_key(lambda x, y: 1 if x+y < y+x else -1))
        return ''.join(nums).lstrip('0') or '0'