class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        k = (nums[-1] - nums[0]) // (len(nums) - 1)
        arr = [0] * len(nums)
        for i in range(len(nums)):
            arr[i] = nums[i] - k * i
        return arr