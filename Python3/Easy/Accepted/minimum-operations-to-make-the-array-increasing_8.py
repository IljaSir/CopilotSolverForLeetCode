class Solution:
    def minOperations(self, nums: List[int]) -> int:
        
        # this is a greedy algorithm
        # the solution is to keep track of the highest value seen so far
        # and add the difference between the current value and the highest value
        # seen so far to the total count
        # the highest value seen so far will change if the current value is less
        # than the highest value seen so far
        # the highest value seen so far will stay the same if the current value
        # is greater than the highest value seen so far
        highest = 0
        count = 0
        for i in range(len(nums)):
            if nums[i] <= highest:
                count += highest - nums[i] + 1
                highest += 1
            else:
                highest = nums[i]
        return count