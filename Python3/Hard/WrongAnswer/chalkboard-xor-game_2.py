class Solution:
    def xorGame(self, nums: List[int]) -> bool:
        
        return sum(nums) == 0 or len(nums) % 2 == 0