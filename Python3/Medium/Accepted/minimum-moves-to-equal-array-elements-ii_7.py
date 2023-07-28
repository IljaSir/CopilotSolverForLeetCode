class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        
        nums.sort()
        mid = len(nums)//2
        return sum(abs(num - nums[mid]) for num in nums)