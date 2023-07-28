class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        return sum(bin(x ^ y).count('1') for x in nums for y in nums if x < y)