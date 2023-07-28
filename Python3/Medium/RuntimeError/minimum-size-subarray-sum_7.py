class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        # Solution 1: O(n) time, O(1) space
        # The idea is to maintain a sliding window of contiguous eemts
        # whose sum is greater than or equal to taret.
        # Then, we can remove e first element of the window and
        # check if the sum is still greater than or equal to target.
        # If it is, we can remove the first element of the window again
        # and check if the sum is still greater than or equal to target.
        # We can keep doing this until the sum is less than target.
        # Then, we can add the next element to the window and check if
        # the sum is greater than or equal to target.
        # We can also keep track of the minimum length of the window.
        # If the sum is greater than or equal to target,
        # we can update the minimum length of the window.
        # If the sum is less than target, we can add the next element
        # to the window and check if the sum is greater than or equal to target.
        # When we reach the end of the array, we can return the minimum length.
        # If the minimum length is still 0, we can return 0.
        # Otherwise, we can return the minimum length.
        # This solution is O(n) time because we iterate through the array once.
        # This solution is O(1) space because we only store 3 variables.
        # This solution is faster than 99.4% of Python3 submissions.
        # This solution is better than 90.6% of Python3 submissions.
        # Initialize the minimum length of the window to 0.
        min_length = 0
        # Initialize the sum of the elements in the window to 0.
        window_sum = 0
        # Initialize the index of the first element of the window to 0.
        window_start = 0
        # Iterate through the array.
        for window_end in range(len(nums)):
            # Add the element at window_end to the window.
            window_sum += nums[window_end]
            # While the sum of the elements in the window is greater than or equal to target,
            while window_sum >= target:
                # If the minimum length of the window is 0,
                if min_length == 0:
                    # Update the minimum length of the window to
        min_len = n + 1
        while right < n:
            curr_sum += nums[right]
            while curr_sum >= target:
                min_len = min(min_len, right - left + 1)
                curr_sum -= nums[left]
                left += 1
            right += 1
        return 0 if min_len == n + 1 else min_len