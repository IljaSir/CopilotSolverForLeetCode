class Solution:
    def averageValue(self, nums: List[int]) -> int:
        
        return sum(n for n in nums if n % 2 == 0 and n % 3 == 0) // len([n for n in nums if n % 2 == 0 and n % 3 == 0]) if len([n for n in nums if n % 2 == 0 and n % 3 == 0]) > 0 else 0