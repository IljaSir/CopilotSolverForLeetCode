class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        return max((nums[i + 1] for i in range(len(nums) - 1) if nums[i] == key), key = nums.count)