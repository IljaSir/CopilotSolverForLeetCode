class Solution:
    def minOperations(self, nums: List[int]) -> int:
        
        # 1) Iterate through the list
        # 2) If the current number is <= the prev number, increment the current number by 1
        # 3) Keep a count of the number of increments
        # 4) Return the count
        count = 0
        for i in range(1, len(nums)):
            if nums[i] <= nums[i-1]:
                count += nums[i-1] - nums[i] + 1
                nums[i] = nums[i-1] + 1
        return count