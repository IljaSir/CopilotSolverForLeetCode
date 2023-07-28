class Solution:
    def averageValue(self, nums: List[int]) -> int:
        
        return sum([x for x in nums if x % 2 == 0 and x % 3 == 0]) // len([x for x in nums if x % 2 == 0 and x % 3 == 0]) if len([x for x in nums if x % 2 == 0 and x % 3 == 0]) > 0 else 0