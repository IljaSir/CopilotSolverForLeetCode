class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        if n % 2 == 1:
            median = nums[n//2]
        else:
            median = (nums[n//2] + nums[n//2-1]) // 2
        return sum(abs(x-median) for x in nums)