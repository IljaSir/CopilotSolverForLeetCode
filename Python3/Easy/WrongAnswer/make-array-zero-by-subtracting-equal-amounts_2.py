class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        nums.sort()
        total = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                total += i * (nums[i] - nums[i-1])
        return total