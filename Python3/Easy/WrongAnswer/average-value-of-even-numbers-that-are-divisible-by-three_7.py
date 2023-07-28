class Solution:
    def averageValue(self, nums: List[int]) -> int:
        
        return round(sum(i for i in nums if i % 2 == 0 and i % 3 == 0) / len([i for i in nums if i % 2 == 0 and i % 3 == 0])) if len([i for i in nums if i % 2 == 0 and i % 3 == 0]) > 0 else 0