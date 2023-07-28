class Solution:
    def averageValue(self, nums: List[int]) -> int:
        
        return sum([num for num in nums if num % 2 == 0 and num % 3 == 0]) // len([num for num in nums if num % 2 == 0 and num % 3 == 0])