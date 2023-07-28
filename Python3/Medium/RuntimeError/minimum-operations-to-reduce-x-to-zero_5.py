class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        # 1. Find the longest subarray whose sum is (sum(nums) - x)
        # 2. Return len(nums) - len(subarray) if subarray exists, else -1
        target = sum(nums) - x
        if target == 0:
            return len(nums)
        left, right, curr_sum, max_len = 0, 0, 0, -1
        while right < len(nums):
            curr_sum += nums[right]
            while curr_sum > target:
                curr_sum -= nums[left]
                left += 1
            if curr_sum == target:
                max_len = max(max_len, right - left + 1)
            right += 1
        return len(nums) - max_len if max_len != -1 else -1