class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        # O(n) solution
        # Sliding window
        # Time  complexity: O(n)
        # Space complexity: O(1)
        total = 0
        left = 0
        min_length = float('inf')
        for right, num in enumerate(nums):
            total += num
            while total >= target:
                min_length = min(min_length, right - left + 1)
                total -= nums[left]
                left += 1
        return 0 if min_length == float('inf') else min_length