class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        
        # 1. Find the number of 1's in the array
        # 2. Find the number of 1's in the sliding window of size 1's
        # 3. Find the max number of 1's in the sliding window
        # 4. The number of swaps required is (number of 1's in the sliding window) - (max number of 1's in the sliding window)
        # 5. Move the sliding window to the right and repeat 2-4
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        num_ones = 0
        for num in nums:
            if num == 1:
                num_ones += 1
        max_ones = 0
        window_size = 0
        for i in range(len(nums)):
            if nums[i] == 1:
                window_size += 1
            if i >= num_ones:
                if nums[i - num_ones] == 1:
                    window_size -= 1
            max_ones = max(max_ones, window_size)
        return num_ones - max_ones