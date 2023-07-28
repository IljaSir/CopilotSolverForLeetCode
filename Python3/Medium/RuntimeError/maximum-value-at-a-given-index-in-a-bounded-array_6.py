class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        # The idea is to find the maximum value of nums[index] by binary search.
        # The value of nums[index] is the maximum value of the array.
        # The minimum value of nums[index] is 1.
        # The maximum value of nums[index] is maxSum - n + 1.
        # The sum of the array is the sum of the left side of nums[index] and the sum of the right side of nums[index].
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] / 2.
        # The sum of the right side of nums[index] is (nums[index] + 1) * (nums[index] - 1) / 2.
        # The sum of the left side of nums[index] is (nums[index] + 1) * nums[index] /