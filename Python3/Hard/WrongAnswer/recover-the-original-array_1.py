class Solution:
    def recoverArray(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        k = (nums[-1] - nums[0]) // (len(nums) - 1)
        arr = [nums[0] - k]
        for i in range(1, len(nums)):
            arr.append(arr[-1] + k + (nums[i] - nums[i-1]) % k)
        return arr