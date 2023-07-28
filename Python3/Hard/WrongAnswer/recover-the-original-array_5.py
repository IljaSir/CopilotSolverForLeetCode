class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        k = (nums[len(nums)//2] - nums[len(nums)//2-1]) // 2
        return [i-k for i in nums]